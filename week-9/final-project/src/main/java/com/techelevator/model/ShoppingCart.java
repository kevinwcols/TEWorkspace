package com.techelevator.model;

public class ShoppingCart {

    // Variable definitions
    private int cartItemId;
    private int userId;
    private int productId;
    private int quantity;

    public ShoppingCart() {
    }

    public ShoppingCart(int userId, int quantity, int productId, int cartItemId) {
        this.cartItemId = cartItemId;
        this.userId = userId;
        this.quantity = quantity;
        this.productId = productId;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() { return productId; }

    public void setProductId(int productId) { this.productId = productId; }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}