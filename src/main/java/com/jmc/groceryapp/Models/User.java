package com.jmc.groceryapp.Models;

import javafx.beans.property.*;

public class User {
    private final IntegerProperty userID = new SimpleIntegerProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty userName = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty userRole = new SimpleStringProperty();


    public User(String firstName, String lastName, String userName, String password, String userRole){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.userName.set(userName);
        this.password.set(password);
        this.userRole.set(userRole);
    }

    public int getUserID() {return userID.get();}

    public void setUserID(int userID) {this.userID.set(userID);}

    public StringProperty getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName.set(firstName);}

    public StringProperty getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName.set(lastName);}

    public StringProperty getUserName() {return userName;}

    public void setUserName(String userName) {this.userName.set(userName);}

    public StringProperty getPassword() {return password;}

    public void setPassword(String password) {this.password.set(password);}

    public StringProperty getUserRole() {return userRole;}

    public void setUserRole(String userRole) {this.userRole.set(userRole);}
}
