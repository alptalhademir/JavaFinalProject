package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.Product;
import javafx.collections.ObservableList;

import java.util.List;

public interface ProductDAO {
    Product getProduct(int productID);

    ObservableList<Product> getAllProducts();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);
}
