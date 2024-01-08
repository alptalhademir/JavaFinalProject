package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.Customer;

public interface CustomerDAO extends UserDAO {
    Customer getCustomer(int customerID);

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

}
