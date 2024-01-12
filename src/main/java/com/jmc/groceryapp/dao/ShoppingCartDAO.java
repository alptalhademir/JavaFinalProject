package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.Product;
import com.jmc.groceryapp.Models.ShoppingCart;
import com.jmc.groceryapp.Models.ShoppingCartItem;


import java.util.List;

public interface ShoppingCartDAO {
    void addItem(Product product, float amount, ShoppingCart cart);

    void removeItem(Product product);

    void updateItemQuantity(Product product, float amount);

    void clearCart();

    List<ShoppingCartItem> getItems();

    int getNumberOfItems();

    float getTotal();
}
