package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.Product;
import com.jmc.groceryapp.Models.ShoppingCart;
import com.jmc.groceryapp.Models.ShoppingCartItem;
import com.jmc.groceryapp.dao.ShoppingCartDAO;
import com.jmc.groceryapp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    private final DatabaseConnection databaseConnection;
    private final ShoppingCart cart;

    public ShoppingCartDAOImpl(DatabaseConnection databaseConnection, ShoppingCart cart) {
        this.databaseConnection = databaseConnection;
        this.cart = cart;
    }

    @Override
    public void addItem(Product product, float amount, ShoppingCart cart) {
        try {
            // Create a new ShoppingCartItem
            ShoppingCartItem item = new ShoppingCartItem(product, amount);
            cart.getItems().add(item);

            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO shopping_cart_items (product_id, quantity, cart_id) VALUES (?, ?, ?)");

            statement.setInt(1, product.getProductID());
            statement.setFloat(2, amount);


            statement.setInt(3, cart.getCartID());


            statement.executeUpdate();


            statement.close();
            databaseConnection.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeItem(Product product) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM shopping_cart_items WHERE product_id = ?");

            statement.setInt(1, product.getProductID());

            statement.executeUpdate();
            databaseConnection.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItemQuantity(Product product, float amount) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE shopping_cart_items SET quantity = ? WHERE product_id = ?");

            statement.setFloat(1, amount);
            statement.setInt(2, product.getProductID());

            statement.executeUpdate();
            databaseConnection.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearCart() {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM shopping_cart_items WHERE cart_id = ?");

            statement.setInt(1, cart.getCartID());

            statement.executeUpdate();
            databaseConnection.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ShoppingCartItem> getItems() {
        return null;
    }

    /*@Override
    public List<ShoppingCartItem> getItems() {
        List<ShoppingCartItem> items = new ArrayList<>();

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT product_id, quantity FROM shopping_cart_items WHERE cart_id = ?");
            statement.setInt(1, cart.getCartID());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                float quantity = resultSet.getFloat("quantity");

                // You need to retrieve the corresponding Product object based on productId.
                // Assuming you have a method getProductById in your ProductDAO, replace it with your actual implementation

                // Create a ShoppingCartItem and add it to the list
                ShoppingCartItem item = new ShoppingCartItem(product, quantity);
                items.add(item);
            }

            databaseConnection.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }*/



    @Override
    public int getNumberOfItems() {
        int numberOfItems = 0;
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT COUNT(*) AS count FROM shopping_cart_items WHERE cart_id = ?");

            statement.setInt(1, cart.getCartID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                numberOfItems = resultSet.getInt("count");
            }

            databaseConnection.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            return numberOfItems;
        }

        return numberOfItems;
    }

    @Override
    public float getTotal() {
        float total = 0.0f;

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT SUM(product.price * shopping_cart_items.quantity) AS total " +
                            "FROM shopping_cart_items " +
                            "JOIN product_info AS product ON shopping_cart_items.product_id = product.product_id " +
                            "WHERE cart_id = ?");

            statement.setInt(1, cart.getCartID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                total = resultSet.getFloat("total");
            }

            databaseConnection.disconnect();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, logging or throwing it.
        }

        return total;
    }
}
