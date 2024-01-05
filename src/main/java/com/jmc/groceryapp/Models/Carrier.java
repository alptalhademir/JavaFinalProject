package com.jmc.groceryapp.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Carrier extends User {
    private final StringProperty PhoneNumber;
    private final ObjectProperty<LocalDate> creationDate;

    public Carrier(String fName, String lName, String uName, String Password,String pNumber, LocalDate cDate){
        super(fName, lName, uName, Password);

        this.PhoneNumber=new SimpleStringProperty(this, "PhoneNumber", pNumber);
        this.creationDate=new SimpleObjectProperty<>(this, "creationDate", cDate);


    }


    public StringProperty PhoneNumberProperty() {return PhoneNumber;}
    public ObjectProperty<LocalDate> creationDateProperty() {return creationDate;}
}
