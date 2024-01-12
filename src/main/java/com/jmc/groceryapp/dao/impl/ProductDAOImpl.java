package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.Product;
import com.jmc.groceryapp.dao.ProductDAO;
import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private final DatabaseConnection databaseConnection;

    public ProductDAOImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    @Override
    public Product getProduct(int productID) {
        Product product = null;
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product_info " +
                    "WHERE ProductID = ?");
            statement.setInt(1, productID);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                product = new Product(resultSet.getInt("ProductID"), resultSet.getString("Name"),
                        resultSet.getString("Type"), resultSet.getDouble("Price"),
                        resultSet.getDouble("Stock"), resultSet.getDouble("Threshold"));

                product.setProductID(resultSet.getInt("ProductID"));
                product.setName(resultSet.getString("Name"));
                product.setType(resultSet.getString("Type"));
                product.setPrice(resultSet.getDouble("Price"));
                product.setStock(resultSet.getDouble("Stock"));
                product.setThreshold(resultSet.getDouble("Threshold"));
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product_info WHERE Stock > 0");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product(resultSet.getInt("ProductID"), resultSet.getString("Name"),
                        resultSet.getString("Type"), resultSet.getDouble("Price"),
                        resultSet.getDouble("Stock"), resultSet.getDouble("Threshold"));

                product.setProductID(resultSet.getInt("ProductID"));
                product.setName(resultSet.getString("Name"));
                product.setType(resultSet.getString("Type"));
                product.setPrice(resultSet.getDouble("Price"));
                product.setStock(resultSet.getDouble("Stock"));
                product.setThreshold(resultSet.getDouble("Threshold"));

                products.add(product);
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }


    @Override
    public void addProduct(Product product) {
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO product_info " +
                    "(Name, Type, Price, Stock, Threshold) VALUES (?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setDouble(3, product.getPrice());
            statement.setDouble(4, product.getStock());
            statement.setDouble(5, product.getThreshold());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE product_info SET " +
                    "Name = ?, Type = ?, Price = ?, Stock = ?, Threshold = ? WHERE ProductID = ?");
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setDouble(3, product.getPrice());
            statement.setDouble(4, product.getStock());
            statement.setDouble(5, product.getThreshold());
            statement.setInt(6, product.getProductID());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Product product) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM product_info WHERE ProductID = ?");
            statement.setInt(1, product.getProductID());

            statement.executeUpdate();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getTotalFruits() {
        int totalFruits = 0;

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM product_info WHERE Type = 'Fruit' AND Stock > 0");

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                totalFruits = resultSet.getInt(1);
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalFruits;
    }

    public int getTotalVegetables() {
        int totalVegetables = 0;

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM product_info WHERE Type = 'Vegetable' AND Stock > 0");

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                totalVegetables = resultSet.getInt(1);
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalVegetables;
    }

}
