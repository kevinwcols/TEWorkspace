package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Products {
    // Variable definitions from product table in m2_final_project db
    private int productId;
    private String productSku;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private BigDecimal price;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String imageName;

    // Constructors
    public Products() {
    }

    public Products(int productId, String product_sku, String name, String description, BigDecimal price, String imageName) {
        this.productId = productId;
        this.productSku = product_sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }

    // Getters and Setters
    public int getProduct_id() {
        return productId;
    }

    public void setProduct_id(int productId) {
        this.productId = productId;
    }

    public String getProduct_sku() {
        return productSku;
    }

    public void setProduct_sku(String productSku) {
        this.productSku = productSku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage_name() {
        return imageName;
    }

    public void setImage_name(String imageName) {
        this.imageName = imageName;
    }

}
