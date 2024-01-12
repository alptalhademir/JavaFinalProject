package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.Order;
import com.jmc.groceryapp.Models.ShoppingCartItem;
import com.jmc.groceryapp.dao.OrderDAO;
import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAOImpl implements OrderDAO {

    private final DatabaseConnection databaseConnection;

    public OrderDAOImpl(DatabaseConnection databaseConnection) {this.databaseConnection = databaseConnection;}

    @Override
    public Order getOrder(int OrderID) {
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_info " +
                    "WHERE OrderID = ?");
            statement.setInt(1, OrderID);
            ObservableList<ShoppingCartItem> items = FXCollections.observableArrayList();
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Order order = new Order(resultSet.getTimestamp("OrderTime").toLocalDateTime(),
                        resultSet.getTimestamp("DeliveryTime").toLocalDateTime(),
                        items, resultSet.getBoolean("IsDelivered"),
                        resultSet.getDouble("TotalCost"));


                order.setOrderTime(resultSet.getTimestamp("OrderTime").toLocalDateTime());
                order.setDeliveryTime(resultSet.getTimestamp("DeliveryTime").toLocalDateTime());
                order.setTotalcost(resultSet.getDouble("TotalCost"));
                order.setIsDelivered(resultSet.getBoolean("IsDelivered"));

                return order;
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void addOrder(Order order) {
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO order_info " +
                    "(OrderTime, DeliveryTime, TotalCost) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setObject(1, order.getOrderTime());
            statement.setObject(2, order.getDeliveryTime());
            statement.setDouble(3, order.getTotalcost());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order order) {
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE order_info SET " +
                    "OrderTime = ?, DeliveryTime = ?, TotalCost = ?, IsDelivered = ? WHERE OrderID = ?");
            statement.setObject(1, order.getOrderTime());
            statement.setObject(2, order.getDeliveryTime());
            statement.setDouble(3, order.getTotalcost());
            statement.setBoolean(4, order.getIsDelivered());
            statement.setInt(5, order.getOrderID());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeOrder(Order order) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM order_info WHERE OrderID = ?");
            statement.setInt(1, order.getOrderID());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }


}
