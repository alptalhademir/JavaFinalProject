package com.jmc.groceryapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String DATABASE_URL =
            "jdbc:mysql://localhost:3306/grocery_project";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "password";

    private Connection connection;

    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER,
                    DATABASE_PASSWORD);
        }
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()){
            connection.close();
        }
    }

    public void createTablesIfNotExist() throws SQLException {
        // Connect to the db
        connect();

        // Create User table
        String sqlUser= "CREATE TABLE IF NOT EXISTS user_info (" +
                "UserId INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "UserName VARCHAR(255) UNIQUE," +
                "FirstName VARCHAR(255)," +
                "LastName VARCHAR(255)," +
                "Password VARCHAR(255)," +
                "UserRole VARCHAR(255)," +
                ");";

        Statement stmtUser = connection.createStatement();
        stmtUser.execute(sqlUser);

        // Create Customer table
        String sqlCustomer= "CREATE TABLE IF NOT EXISTS customer_info (" +
                "CustomerId INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "Address VARCHAR(255)," +
                "PhoneNumber VARCHAR(255)," +
                "CreationDate DATE," +
                "FOREIGN KEY (UserId) REFERENCES user_info(UserId)" +
                ");";

        Statement stmtCustomer = connection.createStatement();
        stmtCustomer.execute(sqlCustomer);

        // Disconnect from the db
        disconnect();
    }

    public Connection getConnection(){return connection;}

}
