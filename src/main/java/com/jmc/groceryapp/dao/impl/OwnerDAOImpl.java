package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.Models.Customer;
import com.jmc.groceryapp.dao.OwnerDAO;
import com.jmc.groceryapp.Models.Owner;
import com.jmc.groceryapp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class OwnerDAOImpl extends UserDAOImpl implements OwnerDAO {

    private final DatabaseConnection databaseConnection;

    public OwnerDAOImpl(DatabaseConnection databaseConnection, DatabaseConnection databaseConnection1) {
        super(databaseConnection);
        this.databaseConnection = databaseConnection;
}

    @Override
    public Owner getOwner(int ownerID) {

        Owner owner = null;
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer_info " +
                    "WHERE CustomerID = ?");
            statement.setInt(1, ownerID);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                owner = new Owner(resultSet.getString("fName"),
                                    resultSet.getString("lName"),
                                    resultSet.getString("uName"),
                                    resultSet.getString("Password"),
                                    resultSet.getDate("cDate").toLocalDate(),
                                    resultSet.getString("pStatus"));

                owner.setFirstName(resultSet.getString("fName"));
                owner.setLastName(resultSet.getString("lName"));
                owner.setUserName(resultSet.getString("uName"));
                owner.setPassword(resultSet.getString("Password"));
                owner.creationDateProperty().set(resultSet.getDate("cDate").toLocalDate());
                owner.PurchaseStatusProperty().set(resultSet.getString("pStatus"));
            }

            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            // error handling part
        }
        return owner;

    }

    @Override
    public void addOwner(Owner owner) {

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO owner_info (fName, lName, uName, Password, CreationDate, PurchaseStatus) " +
                            "VALUES (?, ?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, owner.getFirstName());
            statement.setString(2, owner.getLastName());
            statement.setString(3, owner.getUserName());
            statement.setString(4, owner.getPassword());
            statement.setDate(5, java.sql.Date.valueOf(owner.creationDateProperty().get()));
            statement.setString(6, owner.PurchaseStatusProperty().get());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void updateOwner(Owner owner) {

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE owner_info SET fName = ?, lName = ?, uName = ?, Password = ?" +
                            "CreationDate = ?, PurchaseStatus = ? ");
            statement.setString(1, owner.getFirstName());
            statement.setString(2, owner.getLastName());
            statement.setString(3, owner.getUserName());
            statement.setString(4, owner.getPassword());
            statement.setDate(5, java.sql.Date.valueOf(owner.creationDateProperty().get()));
            statement.setString(6, owner.PurchaseStatusProperty().get());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            // error handling part
            e.printStackTrace();
        }
    }



    @Override
    public void deleteOwner(Owner owner) {

        try {
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM owner_info WHERE OwnerID = ?");
            statement.setInt(1, owner.getOwnerID());  // Assuming you have a method getOwnerID in your Owner class

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        } catch (Exception e) {
            // error handling part
            e.printStackTrace();
        }
    }
    }





