package com.techelevator.controller;

import com.techelevator.dao.ProductsDao;
import com.techelevator.model.Products;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The ProductsController is a class for handling HTTP Requests related to reading Products
 *
 * It depends on an instance of ProductsDao for interacting with DAOs
 */
@RestController
@PreAuthorize("permitAll()")
@RequestMapping( path = "/products" )
public class ProductsController {

    // Import ProductsDao methods
    private ProductsDao ProductsDao;

    public ProductsController(ProductsDao productsDao) {
        this.ProductsDao = productsDao;
    }

    @RequestMapping( method = RequestMethod.GET )
    public List<Products> searchForProducts(@RequestParam(required = false) String sku,
                                            @RequestParam(required = false) String name) {
        if ( sku != null || name != null ) {
            return ProductsDao.getProductsSearch(sku, name);
        }
        return ProductsDao.getProductsForSale();
    }

    @RequestMapping( path = "/{id}", method = RequestMethod.GET )
    public List<Products> getSingleProducts(@PathVariable int id) {
        return ProductsDao.getProductsForSaleDetail(id);
    }

}
