package com.jmc.groceryapp.Models;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

public class Order {
    private final IntegerProperty orderID;
    private final ObjectProperty<LocalDateTime> orderTime;
    private final ObjectProperty<LocalDateTime> deliveryTime;
    private final ObservableList<ShoppingCartItem> items;
    private final BooleanProperty isDelivered;
    private final DoubleProperty totalcost;

    public Order(LocalDateTime orderTime, LocalDateTime deliveryTime, ObservableList<ShoppingCartItem> items,
                 boolean isDelivered, double totalcost) {
        this.orderID = new SimpleIntegerProperty();
        this.orderTime = new SimpleObjectProperty<>(orderTime);
        this.deliveryTime = new SimpleObjectProperty<>(deliveryTime);
        this.items = items;
        this.isDelivered = new SimpleBooleanProperty(isDelivered);
        this.totalcost = new SimpleDoubleProperty(totalcost);
    }

    public int getOrderID() {return orderID.get();}
    public IntegerProperty orderIDProperty() {return orderID;}
    public void setOrderID(int orderID) {this.orderID.set(orderID);}

    public LocalDateTime getOrderTime() {return orderTime.get();}
    public ObjectProperty<LocalDateTime> orderTimeProperty() {return orderTime;}
    public void setOrderTime(LocalDateTime orderTime) {this.orderTime.set(orderTime);}

    public LocalDateTime getDeliveryTime() {return deliveryTime.get();}
    public ObjectProperty<LocalDateTime> deliveryTimeProperty() {return deliveryTime;}
    public void setDeliveryTime(LocalDateTime deliveryTime) {this.deliveryTime.set(deliveryTime);}

    public ObservableList<ShoppingCartItem> getItems() {return items;}
    public void setItems(ObservableList<ShoppingCartItem> items) {this.items.setAll(items);}

    public boolean getIsDelivered() {return isDelivered.get();}
    public BooleanProperty isDeliveredProperty() {return isDelivered;}
    public void setIsDelivered(boolean isDelivered) {this.isDelivered.set(isDelivered);}

    public double getTotalcost() {return totalcost.get();}
    public DoubleProperty totalcostProperty() {return totalcost;}
    public void setTotalcost(double totalcost) {this.totalcost.set(totalcost);}

}
