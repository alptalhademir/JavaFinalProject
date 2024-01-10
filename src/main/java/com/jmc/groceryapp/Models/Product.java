package com.jmc.groceryapp.Models;

public class Product {
    private int productID;
    private String name;
    private String type;
    private float price;
    private float stock;
    private float threshold;

    public Product(int productID, String name, String type, float price, float stock, float threshold){
        this.productID = productID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
        this.threshold = threshold;
    }

    public int getProductID() {return productID;}

    public void setProductID(int productID) {this.productID = productID;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public float getPrice() {return price;}

    public void setPrice(float price) {this.price = price;}

    public float getStock() {return stock;}

    public void setStock(float stock) {this.stock = stock;}

    public float getThreshold() {return threshold;}

    public void setThreshold(float threshold) {this.threshold = threshold;}
}
