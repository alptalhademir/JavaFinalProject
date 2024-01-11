package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.User;

import java.sql.SQLException;

public interface UserDAO {
    User getUser(int userID);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    boolean doesUsernameExist(String username);


}
