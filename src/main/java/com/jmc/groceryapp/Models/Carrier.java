package com.jmc.groceryapp.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Carrier extends User {
    private int carrierID;
    private String phoneNumber;
    private LocalDate creationDate;

    public Carrier(String firstName, String lastName, String userName, String password, String userRole,
                   String phoneNumber, LocalDate creationDate){
        super(fName, lName, uName, Password,"Carrier");

        this.phoneNumber = phoneNumber;
        this.creationDate = creationDate;


    }

    public int getCarrierID() {return carrierID;}

    public void setCarrierID(int carrierID) {this.carrierID = carrierID;}


    public LocalDate getCreationDate() {return creationDate;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}
}
