package com.jmc.groceryapp.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Customer extends User {

    private final StringProperty Address;
    private final StringProperty PhoneNumber;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> updateAccount;
    private final ObjectProperty<LocalDate> creationDate;
    private final StringProperty orderStatus;


    public Customer( String fName, String lName, String uName, String Password, String address, String pNumber, Account cAccount, Account uAccount, LocalDate cDate, String oStatus ){
        super(fName, lName, uName, Password);

        this.Address=new SimpleStringProperty(this, "Address", address);
        this.PhoneNumber=new SimpleStringProperty(this, "PhoneNumber", pNumber);
        this.checkingAccount=new SimpleObjectProperty<>(this, "checkingAccount", cAccount);
        this.updateAccount=new SimpleObjectProperty<>(this, "updateAccount", uAccount);
        this.creationDate=new SimpleObjectProperty<>(this, "creationDate", cDate);
        this.orderStatus=new SimpleStringProperty(this, "orderStatus", oStatus);



    }

    public StringProperty AddressProperty() {return Address;}
    public StringProperty PhoneNumberProperty() {return PhoneNumber;}
    public ObjectProperty<Account> checkingAccountProperty() {return checkingAccount;}
    public ObjectProperty<Account> updateAccountProperty() {return updateAccount;}
    public ObjectProperty<LocalDate> creationDateProperty() {return creationDate;}
    public StringProperty orderStatusProperty() {return orderStatus;}
}
