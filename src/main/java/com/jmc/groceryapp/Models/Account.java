package com.jmc.groceryapp.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Account {
    private final StringProperty owner;
    private final StringProperty account_id;
    private final StringProperty orders;

    public Account(String owner, String account_id, String orders){
        this.owner=new SimpleStringProperty(this, "owner", owner);
        this.account_id=new SimpleStringProperty(this, "account_id", account_id);
        this.orders=new SimpleStringProperty(this, "orders", orders);

    }

    public StringProperty ownerProperty() {return owner;}
    public StringProperty account_idProperty() {return account_id;}
    public StringProperty ordersProperty() {return orders;}



}
