package com.jmc.groceryapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public Connection getConnection(){
        return connection;
    }

}
