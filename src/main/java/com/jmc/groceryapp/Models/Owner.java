package com.jmc.groceryapp.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Owner extends User {

    private final ObjectProperty<LocalDate> creationDate;
    private final StringProperty PurchaseStatus;

    private int ownerID;


    public Owner( String fName, String lName, String uName, String Password,LocalDate cDate, String pStatus){
        super(fName, lName, uName, Password, "Owner");

        this.creationDate=new SimpleObjectProperty<>(this, "creationDate", cDate);
        this.PurchaseStatus=new SimpleStringProperty(this, "PurchaseStatus", pStatus);

    }


    public ObjectProperty<LocalDate> creationDateProperty() {return creationDate;}
    public StringProperty PurchaseStatusProperty() {return PurchaseStatus;}


    public int getOwnerID() {return ownerID;}

    public void setOwnerID(int ownerID) {this.ownerID = ownerID;}}
