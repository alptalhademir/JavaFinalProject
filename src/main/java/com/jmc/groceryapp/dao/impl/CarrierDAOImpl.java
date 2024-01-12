package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.Carrier;
import com.jmc.groceryapp.Models.Customer;
import com.jmc.groceryapp.Models.Product;
import com.jmc.groceryapp.dao.CarrierDAO;
import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarrierDAOImpl extends UserDAOImpl implements CarrierDAO {

    private final DatabaseConnection databaseConnection;

    public CarrierDAOImpl(DatabaseConnection databaseConnection, DatabaseConnection databaseConnection1) {
        super(databaseConnection);
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Carrier getCarrier(int carrierID) {
        Carrier carrier = null;


        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM carrier_info " +
                    "WHERE CarrierID = ?");
            statement.setInt(1, carrierID);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                carrier = new Carrier(resultSet.getString("FirstName"), resultSet.getString("LastName"),
                        resultSet.getString("UserName"), resultSet.getString("Password"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getDate("CreationDate").toLocalDate());


                carrier.setFirstName(resultSet.getString("FirstName"));
                carrier.setLastName(resultSet.getString("LastName"));
                carrier.setUserName(resultSet.getString("UserName"));
                carrier.setPassword(resultSet.getString("Password"));
                carrier.setUserRole(resultSet.getString("UserRole"));

            }
            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            // error handling part
        }
        return carrier;


    }

    @Override
    public void addCarrier(Carrier carrier) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO carrier_info " +
                    "(FirstName, LastName, UserName, Password, UserRole, PhoneNumber, CreationDate) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, carrier.getFirstName());
            statement.setString(2, carrier.getLastName());
            statement.setString(3, carrier.getUserName());
            statement.setString(4, carrier.getPassword());
            statement.setString(5, carrier.getUserRole());
            statement.setString(6, carrier.getPhoneNumber());
            statement.setDate(7, java.sql.Date.valueOf(carrier.getCreationDate()));

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            // error handling part
        }
    }


    @Override
    public void updateCarrier(Carrier carrier) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE carrier_info SET FirstName = ?," +
                    " LastName = ?, UserName = ?, Password = ?, UserRole = ? WHERE CarrierID = ?");
            statement.setString(1, carrier.getFirstName());
            statement.setString(2, carrier.getLastName());
            statement.setString(3, carrier.getUserName());
            statement.setString(4, carrier.getPassword());
            statement.setString(5, carrier.getUserRole());
            statement.setInt(6, carrier.getCarrierID());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteCarrier(Carrier carrier) {
        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement("DELETE FROM carrier_info " +
                    "WHERE Username = ?");
            statement.setString(1, carrier.getUserName());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Carrier> getAllCarriers() {
        List<Carrier> carriers = new ArrayList<>();

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM carrier_info ");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Carrier carrier = new Carrier(resultSet.getString("FirstName"), resultSet.getString("LastName"),
                        resultSet.getString("UserName"), resultSet.getString("Password"),
                        resultSet.getString("PhoneNumber"), resultSet.getDate("CreationDate").toLocalDate());

                carrier.setFirstName(resultSet.getString("FirstName"));
                carrier.setLastName(resultSet.getString("LastName"));
                carrier.setUserName(resultSet.getString("UserName"));
                carrier.setPassword(resultSet.getString("Password"));
                carrier.setPhoneNumber(resultSet.getString("PhoneNumber"));
                carrier.setCreationDate(resultSet.getDate("CreationDate").toLocalDate());

                carriers.add(carrier);
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return carriers;
    }

    @Override
    public int getTotalCarriers() {
        int totalCarriers = 0;

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) as total FROM carrier_info");

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                totalCarriers = resultSet.getInt("total");
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return totalCarriers;
    }


}

