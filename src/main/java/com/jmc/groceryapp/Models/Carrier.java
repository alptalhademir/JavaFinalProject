package com.jmc.groceryapp.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Carrier {
    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty UserName;
    private final StringProperty Password;
    private final StringProperty PhoneNumber;
    private final ObjectProperty<LocalDate> creationDate;

    public Carrier(String fName, String lName, String uName, String Password, String pNumber, LocalDate cDate){
        this.FirstName=new SimpleStringProperty(this, "FirstName", fName);
        this.LastName=new SimpleStringProperty(this, "LastName", lName);
        this.UserName=new SimpleStringProperty(this, "UserName", uName);
        this.Password=new SimpleStringProperty(this, "Password", Password);
        this.PhoneNumber=new SimpleStringProperty(this, "PhoneNumber", pNumber);
        this.creationDate=new SimpleObjectProperty<>(this, "creationDate", cDate);


    }

    public StringProperty FirstNameProperty() {return FirstName;}
    public StringProperty LastNameProperty() {return LastName;}
    public StringProperty UserNameProperty() {return UserName;}
    public StringProperty PasswordProperty() {return Password;}
    public StringProperty PhoneNumberProperty() {return PhoneNumber;}
    public ObjectProperty<LocalDate> creationDateProperty() {return creationDate;}
}
