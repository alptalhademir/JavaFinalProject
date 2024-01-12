package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.Customer;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;

import java.sql.SQLException;

public interface CustomerDAO extends UserDAO {
    Customer getCustomer(int customerID);

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    boolean doesUsernameExist(String username);

    int getTotalCustomers();
    LineChart<String, Number> createLineChart();

    int getTotalCustomersByAddress();
    LineChart<String, Number> createLineChartAddress();


}
