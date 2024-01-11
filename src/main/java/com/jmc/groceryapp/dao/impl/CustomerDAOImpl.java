package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.Customer;
import com.jmc.groceryapp.dao.CustomerDAO;
import com.jmc.groceryapp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
