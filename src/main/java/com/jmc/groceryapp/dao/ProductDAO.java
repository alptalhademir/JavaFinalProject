package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.Product;

import java.util.List;

public interface ProductDAO {
    Product getProduct(int productID);

    List<Product> getAllProducts();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    int getTotalFruits();

    int getTotalVegetables();
}
