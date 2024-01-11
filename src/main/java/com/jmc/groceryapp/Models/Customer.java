package com.jmc.groceryapp.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Customer extends User {
    private final IntegerProperty customerID = new SimpleIntegerProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty phoneNumber = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> creationDate = new SimpleObjectProperty<>();





    public Customer(String firstName, String lastName, String userName, String password, String userRole,
                    String address, String phoneNumber, LocalDate creationDate, Integer customerID) {
        super(firstName, lastName, userName, password, userRole);


        this.address.set(address);
        this.phoneNumber.set(phoneNumber);
        this.creationDate.set(creationDate);
        this.customerID.set(customerID);


    }



    public IntegerProperty getCustomerID() {return customerID;}

    public void setCustomerID(int customerID) {this.customerID.set(customerID);}

    public StringProperty getAddress() {return address;}

    public void setAddress(String address) {this.address.set(address);}

    public StringProperty getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber.set(phoneNumber);}

    public ObjectProperty<LocalDate> getCreationDate() {return creationDate;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate.set(creationDate);}
}
