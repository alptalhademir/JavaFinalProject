package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.Product;
import com.jmc.groceryapp.Models.ShoppingCart;
import com.jmc.groceryapp.Models.ShoppingCartItem;
import com.jmc.groceryapp.dao.ShoppingCartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;

public class ShoppingCartDAOImpl implements ShoppingCartDAO {
    @Override
    public void addItem(Product product, float amount, ShoppingCart cart) {
        ShoppingCartItem item = new ShoppingCartItem(product, amount);
        cart.getItems().add(item);

        try {
            String sql = "INSERT INTO shopping_cart_items (product_id, quantity, cart_id) VALUES (?, ?, ?)";
            try (Connection connection = cart.getConnection();
                 PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, product.getProductID()); // Assuming you have a method getId() in Product
                pstmt.setFloat(2, amount);
                pstmt.setInt(3, cart.getCartID()); // Assuming you have a method getId() in ShoppingCart

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly in a real application
        }
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