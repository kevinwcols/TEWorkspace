package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

/* Get a product from the datastore that has the given id.
 * If the id is not found, return null.      */
    @Override
    public Product getProduct(int productId) {
        Product product = null;

        String getProductSql =
                "SELECT product_id, name, description, price, image_name FROM product " +
                        "WHERE product_id = ?;";

        SqlRowSet getProductResults =
                jdbcTemplate.queryForRowSet(getProductSql, productId);
        while (getProductResults.next()){
            product = mapRowToProduct(getProductResults);
        }

         return product;
    }

/* Get all products from the datastore, ordered by product_id. */
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT product_id, name, description, price, image_name FROM product;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            products.add(mapRowToProduct(results));
        }

        return products;
    }

/* Get a list of product for which there are no sales yet, ordered by product_id. Only these products may be deleted form the datastore.    */
    @Override
    public List<Product> getProductsWithNoSales() {
        List<Product> products = new ArrayList<>();

        String sql = "SELECT p.product_id, p.name, p.description, p.price, p.image_name FROM product p " +
                        "WHERE p.product_id NOT IN " +
                        "( SELECT li.product_id FROM line_item li );";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            products.add(mapRowToProduct(results));
        }

        return products;
    }

/* Add a new product into the datastore.   */
    @Override
    public Product createProduct(Product newProduct) {
        String sql = "INSERT INTO product ( name, description, price, image_name ) " +
                "VALUES (?, ?, ?, ?) RETURNING product_id";
        Integer product_id =
                jdbcTemplate.queryForObject(sql, Integer.class,
                        newProduct.getName(), newProduct.getDescription(), newProduct.getPrice(), newProduct.getImageName());
        // Product tempProduct = getProduct(product_id);

        // return tempProduct;
        return getProduct(product_id);
    }

/* Update a product in the datastore. Only called on products that are already in the datastore.     */
    @Override
    public void updateProduct(Product updatedProduct) {
        String updateProductSql = "UPDATE product " +
                "SET name = ?, description = ?, price = ?, image_name = ? " +
                "WHERE product_id = ?;";
        Integer numberOfRows =
                jdbcTemplate.update(updateProductSql, updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getPrice(),
                                    updatedProduct.getImageName(), updatedProduct.getProductId());


    }

/* Remove a product from the datastore.    */
    @Override
    public void deleteProduct(int productId) {
        // Only products can be deleted where there are no sales
        String deleteProductSql = "DELETE FROM product p WHERE p.product_id = ? "+
                                        "AND p.product_id NOT IN " +
                                        "(SELECT li.product_id FROM line_item li);";
        jdbcTemplate.update(deleteProductSql, productId);
    }

    private Product mapRowToProduct(SqlRowSet results) {
        Product product = new Product();
        product.setProductId(results.getInt("product_id"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(BigDecimal.valueOf(results.getDouble("price")));
        if ( results.getString("image_name") != null ) {
            product.setImageName(results.getString("image_name"));
        }


        return product;
    }
}
