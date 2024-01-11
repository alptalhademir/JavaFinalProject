package com.jmc.groceryapp.Models;

import javafx.beans.property.*;

public abstract class User {
    private final IntegerProperty userID;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty userName;
    private final StringProperty password;
    private final StringProperty userRole;

    public User(String firstName, String lastName, String userName, String password, String userRole){
        this.userID = new SimpleIntegerProperty();
        this.firstName= new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
        this.userRole = new SimpleStringProperty(userRole);
    }

    public int getUserID() {return userID.get();}
    public IntegerProperty userIDProperty() {return userID;}
    public void setUserID(int userID) {this.userID.set(userID);}

    public String getFirstName() {return firstName.get();}
    public StringProperty firstNameProperty() {return firstName;}
    public void setFirstName(String firstName) {this.firstName.set(firstName);}

    public String getLastName() {return lastName.get();}
    public StringProperty lastNameProperty() {return lastName;}
    public void setLastName(String lastName) {this.lastName.set(lastName);}

    public String getUserName() {return userName.get();}
    public StringProperty userNameProperty() {return userName;}
    public void setUserName(String userName) {this.userName.set(userName);}

    public String getPassword() {return password.get();}
    public StringProperty passwordProperty() {return password;}
    public void setPassword(String password) {this.password.set(password);}

    public String getUserRole() {return userRole.get();}
    public StringProperty userRoleProperty() {return userRole;}
    public void setUserRole(String userRole) {this.userRole.set(userRole);}

}
