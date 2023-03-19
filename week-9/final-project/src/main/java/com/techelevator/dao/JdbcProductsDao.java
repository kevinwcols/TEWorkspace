package com.techelevator.dao;

import com.techelevator.model.Products;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductsDao implements ProductsDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcProductsDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // List<Products> products = new ArrayList<>();

    // Required:  1.) As an unauthenticated user, I can see a list of products for sale.
    @Override
    public List<Products> getProductsForSale() {
        String sql = "SELECT product_id, product_sku, name, description, price, image_name " +
                        "FROM product ORDER BY product_id;";

        List<Products> products = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            // Products tempProduct = mapRowToProducts(results);
            products.add(mapRowToProductsNoDetails(results));
        }

        return products;
    }

    // Required:  2.) As an unauthenticated user, I can search for a list of products by name or SKU.
    @Override
    public List<Products> getProductsSearch(String skuSearch, String nameSearch) {

        if ( skuSearch == null ) {
            skuSearch = "";
        }

        if ( nameSearch == null ) {
            nameSearch = "";
        }

        String sql = "SELECT product_id, product_sku, name, description, price, image_name FROM product " +
                "WHERE product_sku ILIKE ? and name ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%"+skuSearch+"%", "%"+nameSearch+"%");

        List<Products> products = new ArrayList<>();

        while (results.next()) {
            products.add(mapRowToProducts(results));
        }

        return products;
    }

    // Required:  3.) As an unauthenticated user, I can view additional information about a specific product (product detail).
    @Override
    public List<Products> getProductsForSaleDetail(int id) {
        String sql = "SELECT product_id, product_sku, name, description, price, image_name " +
                "FROM product " +
                "WHERE product_id = ?;";

        List<Products> products = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
           products.add(mapRowToProducts(results));
        }

        return products;
    }

    private Products mapRowToProductsNoDetails(SqlRowSet results) {
        Products product = new Products();
        product.setProduct_id(results.getInt("product_id"));
        product.setProduct_sku(results.getString("product_sku"));
        product.setName(results.getString("name"));

        return product;
    }

    private Products mapRowToProducts(SqlRowSet results) {
        Products product = new Products();
        product.setProduct_id(results.getInt("product_id"));
        product.setProduct_sku(results.getString("product_sku"));
        product.setName(results.getString("name"));
        product.setDescription(results.getString("description"));
        product.setPrice(results.getBigDecimal("price"));
        product.setImage_name(results.getString("image_name"));

        return product;
    }
}
