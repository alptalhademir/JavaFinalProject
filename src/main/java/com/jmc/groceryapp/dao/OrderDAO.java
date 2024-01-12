package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.Order;

public interface OrderDAO {
    public Order getOrder(int OrderID);
    public void addOrder(Order order);
    public void removeOrder(Order order);
    public void updateOrder(Order order);
}
