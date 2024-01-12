module com.jmc.groceryapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;


    opens com.jmc.groceryapp to javafx.fxml;
    opens com.jmc.groceryapp.Controllers to javafx.fxml;
    exports com.jmc.groceryapp;
    exports com.jmc.groceryapp.Controllers;
    exports com.jmc.groceryapp.Controllers.Owner;
    exports com.jmc.groceryapp.Controllers.Carrier;
    exports com.jmc.groceryapp.Controllers.Client;
    exports com.jmc.groceryapp.Models;
}