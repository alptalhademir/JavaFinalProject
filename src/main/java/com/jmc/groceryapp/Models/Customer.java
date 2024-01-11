package com.jmc.groceryapp.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Customer extends User {
    private final IntegerProperty customerID;
    private final StringProperty address;
    private final StringProperty phoneNumber;
    private final ObjectProperty<LocalDate> creationDate;
    private ObjectProperty<ShoppingCart> shoppingCart;

    public Customer(String firstName, String lastName, String userName, String password, String address,
                    String phoneNumber, LocalDate creationDate) {
        super(firstName, lastName, userName, password, "Customer");

        this.customerID = new SimpleIntegerProperty();
        this.address = new SimpleStringProperty(address);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.creationDate = new SimpleObjectProperty<>(creationDate);
        this.shoppingCart = null;
    }

    public int getCustomerID() {return customerID.get();}
    public IntegerProperty customerIDProperty() {return customerID;}
    public void setCustomerID(int customerID) {this.customerID.set(customerID);}

    public String getAddress() {return address.get();}
    public StringProperty addressProperty() {return address;}
    public void setAddress(String address) {this.address.set(address);}

    public String getPhoneNumber() {return phoneNumber.get();}
    public StringProperty phoneNumberProperty() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber.set(phoneNumber);}

    public LocalDate getCreationDate() {return creationDate.get();}
    public ObjectProperty<LocalDate> creationDateProperty() {return creationDate;}
    public void setCreationDate(LocalDate creationDate) {this.creationDate.set(creationDate);}

    public ShoppingCart getShoppingCart() {return shoppingCart.get();}
    public ObjectProperty<ShoppingCart> shoppingCartProperty() {return shoppingCart;}
    public void setShoppingCart(ShoppingCart shoppingCart) {this.shoppingCart.set(shoppingCart);}
}
