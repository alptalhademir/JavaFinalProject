package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.Carrier;

public interface CarrierDAO extends UserDAO {
    Carrier getCarrier(int carrierID);

    void addCarrier(Carrier carrier);

    void updateCarrier(Carrier carrier);

    void deleteCarrier(Carrier carrier);

}