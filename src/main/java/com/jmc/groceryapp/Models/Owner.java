package com.jmc.groceryapp.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Owner {
    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty UserName;
    private final StringProperty Password;
    private final ObjectProperty<LocalDate> creationDate;
    private final StringProperty PurchaseStatus;


    public Owner(String fName, String lName, String uName, String Password, LocalDate cDate, String pStatus){
        this.FirstName=new SimpleStringProperty(this, "FirstName", fName);
        this.LastName=new SimpleStringProperty(this, "LastName", lName);
        this.UserName=new SimpleStringProperty(this, "UserName", uName);
        this.Password=new SimpleStringProperty(this, "Password", Password);
        this.creationDate=new SimpleObjectProperty<>(this, "creationDate", cDate);
        this.PurchaseStatus=new SimpleStringProperty(this, "PurchaseStatus", pStatus);

    }

    public StringProperty FirstNameProperty() {return FirstName;}
    public StringProperty LastNameProperty() {return LastName;}
    public StringProperty UserNameProperty() {return UserName;}
    public StringProperty PasswordProperty() {return Password;}
    public ObjectProperty<LocalDate> creationDateProperty() {return creationDate;}
    public StringProperty PurchaseStatusProperty() {return PurchaseStatus;}
}
