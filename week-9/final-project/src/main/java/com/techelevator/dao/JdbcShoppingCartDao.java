package com.techelevator.dao;

import com.techelevator.model.ShoppingCart;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcShoppingCartDao implements ShoppingCartDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcShoppingCartDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

/* Required:  4.) As a user, I can view my shopping cart and see the following details:
     The list of products, quantities, and prices in my cart
     The subtotal of all products in my cart
     The tax amount (in U.S. dollars) charged for my state
     Obtain the tax rate from an external API using the URL: https://teapi.netlify.app/api/statetax?state=[state-code].
     The state code is part of the user address information.
     The tax rate returned from the API is a percentage. Convert this to a decimal value to use in calculating the tax amount.
     The cart total, which is the subtotal plus the amount of tax  */
    @Override
    public List<ShoppingCart> getShoppingCart() {

        String sql = "SELECT p.product_id, p.product_sku, p.name, p.description, p.price, p.image_name, u.user_id, ci.quantity, u.state_code " +
                        "FROM product p " +
                        "JOIN cart_item ci ON ci.product_id = p.product_id " +
                        "JOIN users u ON ci.user_id = u.user_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        List<ShoppingCart> cart = new ArrayList<>();

        while (results.next()) {
            cart.add(mapRowToShoppingCart(results));
        }

        return cart;
    }

/* Required:  5.) As a user, I can add a product to my shopping cart
               If the product is already in my cart, increase the quantity appropriately.
               The quantity added must be positive.  */
    @Override
    public Integer createShoppingCartProduct(ShoppingCart newShoppingCartProduct) {
        String sql = "INSERT INTO cart_item (user_id, product_id, quantity) VALUES" +
                "(?, ?, ?) RETURNING cart_item_id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, newShoppingCartProduct.getUserId(),
                newShoppingCartProduct.getProductId(), newShoppingCartProduct.getQuantity());

        return id;
    }

/* Required:  6.) As a user, I can remove a product from my shopping cart.
           This removes the item from the cart entirely, regardless of the quantity in the cart.  */
    @Override
    public void removeProductFromShoppingCart(int cartItemId, int userId, int productId) {
        String deleteShoppingCartItemSql = "DELETE FROM cart_item WHERE cart_item_id = ? and user_id = ? and product_id = ?;";
        jdbcTemplate.update(deleteShoppingCartItemSql, cartItemId, userId, productId);
    }

// Required:  7.) As a user I can clear my cart, removing all the items from the cart.
    @Override
    public void clearShoppingCart(int cartItemId, int userId) {
        String deleteShoppingCartSql = "DELETE FROM cart_item WHERE cart_item_id = ? and user_id = ?;";
        jdbcTemplate.update(deleteShoppingCartSql, cartItemId, userId);
    }

    // mapToRow of ShoppingCart model
    private ShoppingCart mapRowToShoppingCart(SqlRowSet results) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartItemId(results.getInt("cart_item_id"));
        shoppingCart.setUserId(results.getInt("user_id"));
        shoppingCart.setProductId(results.getInt("product_id"));
        shoppingCart.setQuantity(results.getInt("quantity"));

        return shoppingCart;
    }

}
