package com.jmc.groceryapp.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class User {
    private final StringProperty FirstName;
    private final StringProperty LastName;
    private final StringProperty UserName;
    private final StringProperty Password;

    public User(String fName, String lName, String uName, String Password){
        this.FirstName=new SimpleStringProperty(this, "FirstName", fName);
        this.LastName=new SimpleStringProperty(this, "LastName", lName);
        this.UserName=new SimpleStringProperty(this, "UserName", uName);
        this.Password=new SimpleStringProperty(this, "Password", Password);
    }

    public StringProperty FirstNameProperty() {return FirstName;}
    public StringProperty LastNameProperty() {return LastName;}
    public StringProperty UserNameProperty() {return UserName;}
    public StringProperty PasswordProperty() {return Password;}
}
