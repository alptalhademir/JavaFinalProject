package com.jmc.groceryapp.Controllers;

public class data {
    public static String username;

    public static String address;
    public static String phoneNumber;

    public static String path;


    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        data.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        data.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        data.phoneNumber = phoneNumber;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
