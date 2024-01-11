package com.jmc.groceryapp.dao;

import com.jmc.groceryapp.Models.Owner;
import com.jmc.groceryapp.Models.User;

public interface OwnerDAO extends UserDAO{

    Owner getOwner(int ownerID);

    void addOwner(Owner Owner);

    void updateOwner(Owner Owner);

    void deleteOwner(Owner Owner);
}
