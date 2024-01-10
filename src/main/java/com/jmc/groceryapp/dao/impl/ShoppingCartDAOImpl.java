package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.Product;
import com.jmc.groceryapp.Models.ShoppingCart;
import com.jmc.groceryapp.Models.ShoppingCartItem;
import com.jmc.groceryapp.dao.ShoppingCartDAO;

import java.util.List;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {
    @Override
    public void addItem(Product product, float amount, ShoppingCart cart) {
        ShoppingCartItem item = new ShoppingCartItem(product, amount);
        cart.getItems().add(item);
    }

    @Override
    public void removeItem(Product product) {

    }

    @Override
    public void updateItemQuantity(Product product, float amount) {

    }

    @Override
    public void clearCart() {

    }

    @Override
    public List<ShoppingCartItem> getItems() {
        return null;
    }

    @Override
    public int getNumberOfItems() {
        return 0;
    }

    @Override
    public float getTotal() {
        return 0;
    }
}
