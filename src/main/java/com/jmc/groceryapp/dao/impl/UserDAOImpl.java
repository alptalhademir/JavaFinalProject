package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.User;
import com.jmc.groceryapp.dao.UserDAO;
import com.jmc.groceryapp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private final DatabaseConnection databaseConnection;

    public UserDAOImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public User getUser(int userID) {
        User user = null;
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement= connection.prepareStatement("SELECT * FROM user_info WHERE UserID = ?");
            statement.setInt(1, userID);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User(resultSet.getString("UserName"), resultSet.getString("FirstName"),
                        resultSet.getString("LastName"), resultSet.getString("Password"),
                        resultSet.getString("UserRole"));

                user.setUserName(resultSet.getString("UserName"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setPassword(resultSet.getString("Password"));
                user.setUserRole(resultSet.getString("UserRole"));
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        }

        catch (SQLException e){
            // error handling part
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement= connection.prepareStatement("INSERT INTO user_info (UserName, FirstName," +
                    " LastName, Password, UserRole) VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getUserRole());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (SQLException e){
            // error handling part
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement= connection.prepareStatement("UPDATE user_info SET UserName = ?," +
                    " FirstName = ?, LastName = ?, Password = ?, UserRole = ? WHERE UserId = ?");
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getUserRole());
            statement.setString(6, user.getUserID());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (SQLException e){
            // error handling part
        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement= connection.prepareStatement("DELETE FROM user_info WHERE UserId = ?");
            statement.setString(1, user.getUserID());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (SQLException e){
            // error handling part
        }
    }

    @Override
    public boolean doesUsernameExist(String username) {
        boolean usernameExists = false;
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM user_info WHERE UserName = ?");
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
