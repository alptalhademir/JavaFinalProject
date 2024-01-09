package com.jmc.groceryapp.dao.impl;

import com.jmc.groceryapp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarrierDAOImpl extends UserDAOImpl {

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
            if(resultSet.next()){
                carrier = new Carrier(resultSet.getString("FirstName"), resultSet.getString("LastName"),
                        resultSet.getString("UserName"), resultSet.getString("Password"),
                        resultSet.getString("UserRole");


                carrier.setFirstName(resultSet.getString("FirstName"));
                carrier.setLastName(resultSet.getString("LastName"));
                carrier.setUserName(resultSet.getString("UserName"));
                carrier.setPassword(resultSet.getString("Password"));
                carrier.setUserRole(resultSet.getString("UserRole"));

            }
            resultSet.close();
            statement.close();
            databaseConnection.disconnect();
        }
        catch (Exception e){
            // error handling part
        }
        return carrier;


    }
    //@Override
    public void updateCarrier(Carrier carrier) {
        try{
            databaseConnection.connect();
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE carrier_info SET FirstName = ?," +
                    " LastName = ?, UserName = ?, Password = ?, UserRole = ? WHERE CarrierID = ?");
            statement.setString(1, carrier.getFirstName());
            statement.setString(2, carrier.getLastName());
            statement.setString(3, carrier.getUserName());
            statement.setString(4, carrier.getPassword());
            statement.setString(5, carrier.getUserRole());
            statement.setInt(9, carrier.getCarrierID());

            statement.executeUpdate();

            statement.close();
            databaseConnection.disconnect();
        }

        catch (Exception e){
            // error handling part
        }


        @Override
        public void deleteCarrier(Carrier carrier) {
            try{
                databaseConnection.connect();
                Connection connection = databaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM carrier_info " +
                        "WHERE CarrierID = ?");
                statement.setInt(1, carrier.getCarrierID());

                statement.executeUpdate();

                statement.close();
                databaseConnection.disconnect();
            }

            catch (Exception e){
                // error handling part
            }
        }

}
