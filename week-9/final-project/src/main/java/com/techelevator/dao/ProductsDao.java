package com.techelevator.dao;

import com.techelevator.model.Products;

import java.util.List;

public interface ProductsDao {
    // Required:  1.) As an unauthenticated user, I can see a list of products for sale.
    List<Products> getProductsForSale();

    // Required:  2.) As an unauthenticated user, I can search for a list of products by name or SKU.
    List<Products> getProductsSearch(String skuSearch, String nameSearch);

    // Required:  3.) As an unauthenticated user, I can view additional information about a specific product (product detail).
    List<Products> getProductsForSaleDetail(int productId);
}
