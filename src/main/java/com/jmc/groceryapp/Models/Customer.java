package com.jmc.groceryapp.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Customer extends User {
    private int customerID;
    private String address;
    private String phoneNumber;
    private LocalDate creationDate;

    //private String orderStatus;



    public Customer(String firstName, String lastName, String userName, String password, String userRole,
                    String address, String phoneNumber, LocalDate creationDate) {
        super(firstName, lastName, userName, password, userRole);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;
    }



    public int getCustomerID() {return customerID;}

    public void setCustomerID(int customerID) {this.customerID = customerID;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public LocalDate getCreationDate() {return creationDate;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}
}
