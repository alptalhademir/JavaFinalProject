package com.jmc.groceryapp.Models;

import javafx.beans.property.*;

public class Product {
    private final IntegerProperty productID;
    private final StringProperty name;
    private final StringProperty type;
    private final DoubleProperty price;
    private final DoubleProperty stock;
    private final DoubleProperty threshold;

    public Product(String name, String type, double price, double stock, double threshold){
        this.productID = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleDoubleProperty(stock);
        this.threshold = new SimpleDoubleProperty(threshold);
    }

    public int getProductID() {return productID.get();}
    public IntegerProperty productIDProperty() {return productID;}
    public void setProductID(int productID) {this.productID.set(productID);}

    public String getName() {return name.get();}
    public StringProperty nameProperty() {return name;}
    public void setName(String name) {this.name.set(name);}

    public String getType() {return type.get();}
    public StringProperty typeProperty() {return type;}
    public void setType(String type) {this.type.set(type);}

    public double getPrice() {return price.get();}
    public DoubleProperty priceProperty() {return price;}
    public void setPrice(double price) {this.price.set(price);}

    public double getStock() {return stock.get();}
    public DoubleProperty stockProperty() {return stock;}
    public void setStock(double stock) {this.stock.set(stock);}

    public double getThreshold() {return threshold.get();}
    public DoubleProperty thresholdProperty() {return threshold;}
    public void setThreshold(double threshold) {this.threshold.set(threshold);}
}
