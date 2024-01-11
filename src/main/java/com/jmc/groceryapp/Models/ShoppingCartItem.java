package com.jmc.groceryapp.Models;

import javafx.beans.property.*;

public class ShoppingCartItem {
    private final IntegerProperty itemID;
    private final ObjectProperty<Product> product;
    private final DoubleProperty weight;
    private final DoubleProperty subtotal;

    public ShoppingCartItem(Product product, double weight){
        this.itemID = new SimpleIntegerProperty();
        this.product = new SimpleObjectProperty<>(product);
        this.weight = new SimpleDoubleProperty(weight);
        this.subtotal = new SimpleDoubleProperty();
    }

    public int getItemID() {return itemID.get();}
    public IntegerProperty itemIDProperty() {return itemID;}
    public void setItemID(int itemID) {this.itemID.set(itemID);}

    public Product getProduct() {return product.get();}
    public ObjectProperty<Product> productProperty() {return product;}
    public void setProduct(Product product) {this.product.set(product);}

    public double getWeight() {return weight.get();}
    public DoubleProperty weightProperty() {return weight;}
    public void setWeight(double weight) {this.weight.set(weight);}

    public double getSubtotal() {return subtotal.get();}
    public DoubleProperty subtotalProperty() {return subtotal;}
    public void setSubtotal(double amount) {this.subtotal.set(product.get().getPrice()*amount);}
}
