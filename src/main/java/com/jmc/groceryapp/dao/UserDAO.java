package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.User;

public interface UserDAO {
    User getUser(int userID);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}