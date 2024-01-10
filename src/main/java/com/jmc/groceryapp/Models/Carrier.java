package com.jmc.groceryapp.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Carrier extends User {
    private final IntegerProperty carrierID = new SimpleIntegerProperty();
    private final StringProperty phoneNumber = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> creationDate = new SimpleObjectProperty<>();

    public Carrier(String firstName, String lastName, String userName, String password, String userRole,
                   String phoneNumber, LocalDate creationDate,Integer carrierID){
        super(firstName, lastName, userName, password, userRole);


        this.phoneNumber.set(phoneNumber);
        this.creationDate.set(creationDate);
        this.carrierID.set(carrierID);



    }

    public IntegerProperty getCarrierID() {return carrierID;}

    public void setCarrierID(int carrierID) {this.carrierID.set(carrierID);}

    public StringProperty getPhoneNumber() {return phoneNumber;}
    public ObjectProperty<LocalDate> getCreationDate() {return creationDate;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate.set(creationDate);}
}
