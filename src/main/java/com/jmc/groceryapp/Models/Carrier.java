package com.jmc.groceryapp.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Carrier extends User {
    private final IntegerProperty carrierID;
    private final StringProperty phoneNumber;
    private final ObjectProperty<LocalDate> creationDate;

    private final StringProperty userName;
    private final StringProperty password;

    public Carrier(String firstName, String lastName, String userName, String password, String phoneNumber,
                   LocalDate creationDate){
        super(firstName, lastName, userName, password, "Carrier");

        this.carrierID = new SimpleIntegerProperty();
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.creationDate = new SimpleObjectProperty<>(creationDate);
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
    }

    public int getCarrierID() {return carrierID.get();}
    public IntegerProperty carrierIDProperty() {return carrierID;}
    public void setCarrierID(int carrierID) {this.carrierID.set(carrierID);}

    public String getPhoneNumber() {return phoneNumber.get();}
    public StringProperty phoneNumberProperty() {return phoneNumber;}

    public String getUserName() { return userName.get();}

    public StringProperty userNameProperty() {return userName;}

    public void setUserName(String userName) {this.userName.set(userName);}

    public String getPassword() {return password.get();}

    public StringProperty passwordProperty() {return password;}

    public void setPassword(String password) {this.password.set(password);}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber.set(phoneNumber);}

    public LocalDate getCreationDate() {return creationDate.get();}
    public ObjectProperty<LocalDate> creationDateProperty() {return creationDate;}
    public void setCreationDate(LocalDate creationDate) {this.creationDate.set(creationDate);}
}
