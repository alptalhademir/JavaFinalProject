package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.Customer;
import com.jmc.groceryapp.dao.CustomerDAO;
import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CustomerDAOImpl extends UserDAOImpl implements CustomerDAO {

    private final DatabaseConnection databaseConnection;
    public CustomerDAOImpl(DatabaseConnection databaseConnection, DatabaseConnection databaseConnection1) {
        super(databaseConnection);
        this.databaseConnection = databaseConnection;
    }


    @Override
    public Customer getCustomer(int customerID) {
        Customer customer = null;
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer_info " +
                    "WHERE CustomerID = ?");
            statement.setInt(1, customerID);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                customer = new Customer(resultSet.getString("FirstName"), resultSet.getString("LastName"),
                        resultSet.getString("UserName"), resultSet.getString("Password"),
                        resultSet.getString("Address"), resultSet.getString("PhoneNumber"),
                        resultSet.getDate("CreationDate").toLocalDate());

                customer.setFirstName(resultSet.getString("FirstName"));
                customer.setLastName(resultSet.getString("LastName"));
                customer.setUserName(resultSet.getString("UserName"));
                customer.setPassword(resultSet.getString("Password"));
                customer.setUserRole(resultSet.getString("UserRole"));
                customer.setAddress(resultSet.getString("Address"));
                customer.setPhoneNumber(resultSet.getString("PhoneNumber"));
                customer.setCreationDate(resultSet.getDate("CreationDate").toLocalDate());
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            // error handling part
        }
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO customer_info (FirstName, LastName," +
                    " UserName, Password, UserRole, Address, PhoneNumber, CreationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getUserName());
            statement.setString(4, customer.getPassword());
            statement.setString(5, customer.getUserRole());
            statement.setString(6, customer.getAddress());
            statement.setString(7, customer.getPhoneNumber());
            statement.setDate(8, java.sql.Date.valueOf(customer.getCreationDate()));

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE customer_info SET FirstName = ?," +
                    " LastName = ?, UserName = ?, Password = ?, UserRole = ?, Address = ?, PhoneNumber = ?," +
                    " CreationDate = ? WHERE CustomerID = ?");
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getUserName());
            statement.setString(4, customer.getPassword());
            statement.setString(5, customer.getUserRole());
            statement.setString(6, customer.getAddress());
            statement.setString(7, customer.getPhoneNumber());
            statement.setDate(8, java.sql.Date.valueOf(customer.getCreationDate()));
            statement.setInt(9, customer.getCustomerID());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            // error handling part
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM customer_info " +
                    "WHERE CustomerID = ?");
            statement.setInt(1, customer.getCustomerID());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            // error handling part
        }
    }

    @Override
    public boolean doesUsernameExist(String username) {
        boolean usernameExists = false;
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM customer_info WHERE UserName = ?");
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                usernameExists = count > 0;
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usernameExists;
    }

    @Override
    public int getTotalCustomers() {
        int totalCustomers = 0;
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM customer_info");

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                totalCustomers = resultSet.getInt(1);
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalCustomers;
    }


    public LineChart<String, Number> createLineChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Total Customers");

        series.getData().add(new XYChart.Data<>(String.valueOf(LocalDate.now()), getTotalCustomers()));

        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList(series);
        lineChart.setData(data);

        return lineChart;
    }

    @Override
    public int getTotalCustomersByAddress() {
        int totalCustomers = 0;
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            // Assuming 'address' is the name of the column storing addresses
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM customer_info WHERE address = ?");


            statement.setString(1, "İstanbul");

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                totalCustomers = resultSet.getInt(1);
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalCustomers;
    }

    public LineChart<String, Number> createLineChartAddress() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Customers reside in Istanbul" + " = " + " " + getTotalCustomersByAddress());

        series.getData().add(new XYChart.Data<>("İstanbul", getTotalCustomersByAddress()));

        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList(series);
        lineChart.setData(data);

        return lineChart;
    }

}
