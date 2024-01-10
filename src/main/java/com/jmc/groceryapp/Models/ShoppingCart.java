package com.jmc.groceryapp.Models;

import java.util.List;

public class ShoppingCart {

    private int cartID;
    private List<ShoppingCartItem> items;

    public ShoppingCart(List<ShoppingCartItem> items){
        this.items = items;
    }

    public int getCartID() {return cartID;}

    public void setCartID(int cartID) {this.cartID = cartID;}

    public List<ShoppingCartItem> getItems() {return items;}

    public void setItems(List<ShoppingCartItem> items) {this.items = items;}
}
