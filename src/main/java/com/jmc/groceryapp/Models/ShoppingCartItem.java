package com.jmc.groceryapp.Models;

public class ShoppingCartItem {
    private int itemID;
    private Product product;
    private float weight;
    private float subtotal;

    public ShoppingCartItem(Product product, float weight){
        this.product = product;
        this.weight = weight;
    }

    public int getCartItemID() {return itemID;}

    public void setCartItemID(int itemID) {this.itemID = itemID;}

    public Product getProduct() {return product;}

    public void setProduct(Product product) {this.product = product;}

    public float getWeight() {return weight;}

    public void setWeight(float weight) {this.weight = weight;}

    public float getSubtotal() {return subtotal;}

    public void setSubtotal(float amount) {this.subtotal = product.getPrice()*amount;}
}
