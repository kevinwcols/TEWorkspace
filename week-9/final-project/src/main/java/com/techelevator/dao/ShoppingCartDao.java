package com.techelevator.dao;

import com.techelevator.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao {
    /* Required:  4.) As a user, I can view my shopping cart and see the following details:
         The list of products, quantities, and prices in my cart
         The subtotal of all products in my cart
         The tax amount (in U.S. dollars) charged for my state
         Obtain the tax rate from an external API using the URL: https://teapi.netlify.app/api/statetax?state=[state-code].
         The state code is part of the user address information.
         The tax rate returned from the API is a percentage. Convert this to a decimal value to use in calculating the tax amount.
         The cart total, which is the subtotal plus the amount of tax  */
    List<ShoppingCart> getShoppingCart();

    /* Required:  5.) As a user, I can add a product to my shopping cart
               If the product is already in my cart, increase the quantity appropriately.
               The quantity added must be positive.  */
    Integer createShoppingCartProduct(ShoppingCart newShoppingCartProduct);

    /* Required:  6.) As a user, I can remove a product from my shopping cart.
                       This removes the item from the cart entirely, regardless of the quantity in the cart.  */
    void removeProductFromShoppingCart(int cartItemId, int userId, int productId);

    // Required:  7.) As a user I can clear my cart, removing all the items from the cart.
    void clearShoppingCart(int cartItemId, int userId);

}
