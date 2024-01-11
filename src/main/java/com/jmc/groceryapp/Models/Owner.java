package com.jmc.groceryapp.Models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Owner extends User {
    private final IntegerProperty ownerID;
    private final ObjectProperty<LocalDate> creationDate;
    private final StringProperty purchaseStatus;


    public Owner(String firstName, String lastName, String userName, String password, LocalDate creationDate,
                 String purchaseStatus) {
        super(firstName, lastName, userName, password, "Owner");

        this.ownerID = new SimpleIntegerProperty();
        this.creationDate = new SimpleObjectProperty<>(creationDate);
        this.purchaseStatus = new SimpleStringProperty(purchaseStatus);
    }

    public int getOwnerID() {return ownerID.get();}
    public IntegerProperty ownerIDProperty() {return ownerID;}
    public void setOwnerID(int ownerID) {this.ownerID.set(ownerID);}

    public LocalDate getCreationDate() {return creationDate.get();}
    public ObjectProperty<LocalDate> creationDateProperty() {return creationDate;}
    public void setCreationDate(LocalDate creationDate) {this.creationDate.set(creationDate);}

    public String getPurchaseStatus() {return purchaseStatus.get();}
    public StringProperty PurchaseStatusProperty() {return purchaseStatus;}
    public void setPurchaseStatus(String PurchaseStatus) {this.purchaseStatus.set(PurchaseStatus);}

}