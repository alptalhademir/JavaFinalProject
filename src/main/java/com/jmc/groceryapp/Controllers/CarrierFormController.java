package com.jmc.groceryapp.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CarrierFormController implements Initializable {


    public AnchorPane MainHome_form;
    public TableView orders;
    public TableColumn col_num;
    public TableColumn col_completed;
    public TableColumn col_available;
    public TableColumn col_selected;
    public TableColumn col_date;
    public Label order_id_lbl;
    public TextField order_id_Txt;
    public Label delivery_data_lbl;
    public DatePicker datepicker;
    public Button resetBtn;
    public Button complete_order_btn;
    public AnchorPane orders_form;
    public TableView order_details_table;
    public TableColumn col_number;
    public TableColumn col_orderID;
    public TableColumn col_productList;
    public TableColumn col_customerName;
    public TableColumn col_customerAddress;
    public TableColumn col_totalPrice;
    public TableColumn col_date1;
    public AnchorPane about_us_form;
    public Button home_btn;
    public Button order_btn;
    public Button log_out_btn;
    public Button aboutUs_btn;

    public void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            MainHome_form.setVisible(true);
            orders_form.setVisible(false);
            about_us_form.setVisible(false);
        }
        else if (event.getSource() == order_btn ){
            about_us_form.setVisible(false);
            MainHome_form.setVisible(false);
            orders_form.setVisible(true);
        }
        else {
            about_us_form.setVisible(true);
            MainHome_form.setVisible(false);
            orders_form.setVisible(false);
        }
    }

    public void logout() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to log out?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                log_out_btn.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Register.fxml"));
                Parent root = loader.load();

                // Create a new stage
                Stage stage = new Stage();
                stage.setTitle("Log in");
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
