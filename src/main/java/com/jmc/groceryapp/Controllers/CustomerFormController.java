package com.jmc.groceryapp.Controllers;

import com.jmc.groceryapp.dao.CustomerDAO;
import com.jmc.groceryapp.dao.UserDAO;
import com.jmc.groceryapp.dao.impl.CustomerDAOImpl;
import com.jmc.groceryapp.dao.impl.UserDAOImpl;
import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class CustomerFormController implements Initializable {
    
    public Button home_btn;
    public Button cart_btn;
    public Button order_btn;
    public Button account_btn;
    public Button aboutUs_btn;
    public AnchorPane product_viewer;
    public Label vat_lbl;
    public Label total_lbl;
    public Button pay_btn;
    public Button remove_btn;
    @FXML
    public Button log_out_btn;
    public AnchorPane home_form;
    public AnchorPane about_us_form;
    public AnchorPane orders_form;
    public Label totalOrderLabel;
    public Label completedOrderLabel;
    public Label pendingOrderLabel;
    public Label canceledOrderLabel;
    public TableView past_purchase_table;
    public TableColumn col_num;
    public TableColumn col_orderID;
    public TableColumn col_totalQuantity;
    public TableColumn col_totalPrice;
    public TableColumn col_date;
    public TableColumn col_status;
    public AnchorPane account_form;
    public Label username_lbl;
    public Label phone_lbl;
    public Label address_lbl;
    public TextField currentPasswordTxtField;
    public PasswordField currentPasswordField;
    public TextField newPasswordTxtField;
    public PasswordField newPasswordField;
    public PasswordField confirmPasswordField;
    public Button confirm_btn;
    public TextField confirmPasswordTxtField;
    public AnchorPane shopping_cart_form;
    public TableView cart_details_table;
    public TableColumn col_number;
    public TableColumn col_productName;
    public TableColumn col_amount;
    public TableColumn col_price;
    public Label subtotal_lbl;
    public Button add_btn;
    public Button continue_shopping_btn;
    public AnchorPane phoneChange_form;
    public Label username_phoneChange_lbl;
    public Label phone_phoneChange_lbl;
    public Label address_phoneChange_lbl;
    public TextField currentPasswordTxtField1;
    public TextField newPhoneTxtField;
    public TextField confirmPassword_PhoneTxtField;
    public PasswordField confirmPassword_PhoneField;
    public Button confirm_Phone_btn;
    public Button change_phone_btn;
    public Button change_address_btn;
    public AnchorPane address_change_form;
    public Label username_addressChange_lbl;
    public Label phone_addressChange_lbl;
    public Label address_addressChange_lbl;
    public TextField currentAddressTxtField;
    public TextField newAddressxtField;
    public TextField confirmPassword_AddressTxtField;
    public PasswordField confirmPassword_AddressField;
    public Button confirm_Phone_btn1;
    public Button go_backPhone_btn;
    public Button go_backAddress_btn;
    public DatePicker delivery_datepicker;
    public Button resetBtn;
    public Button confirm_order_btn;
    public Button cancel_order_btn;

    public Label username;
    private UserDAO userDao;
    private CustomerDAO customerDAO;
    private final DatabaseConnection dataBaseConnection= new DatabaseConnection();

    public CustomerFormController() {
        this.userDao = new UserDAOImpl(dataBaseConnection);
        this.customerDAO = new CustomerDAOImpl(dataBaseConnection, dataBaseConnection);
    }
    public void displayUsername() {

        String user = data.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);
        username.setText(user);
        username_lbl.setText(user);
        username_addressChange_lbl.setText(user);
        username_phoneChange_lbl.setText(user);
    }
    public void displayAddress() {
        String user = data.address;

        if (user != null) {
            user = user.substring(0, 1).toUpperCase() + user.substring(1);
            address_lbl.setText(user);
            address_addressChange_lbl.setText(user);
            address_phoneChange_lbl.setText(user);
        } else {
            address_lbl.setText("N/A");
            address_addressChange_lbl.setText(user);
            address_phoneChange_lbl.setText(user);
        }
    }

    public void displayPhoneNumber() {
        String user = data.phoneNumber;

        if (user != null) {
            user = user.substring(0, 1).toUpperCase() + user.substring(1);
            phone_lbl.setText(user);
        } else {

            phone_lbl.setText("N/A");
        }
    }

    public void switchForm(ActionEvent event) {
        if(event.getSource() == home_btn)
        {
            home_form.setVisible(true);
            about_us_form.setVisible(false);
            orders_form.setVisible(false);
            account_form.setVisible(false);
            shopping_cart_form.setVisible(false);
            phoneChange_form.setVisible(false);
            address_change_form.setVisible(false);
        }
        if(event.getSource() == aboutUs_btn) {
            home_form.setVisible(false);
            about_us_form.setVisible(true);
            orders_form.setVisible(false);
            account_form.setVisible(false);
            shopping_cart_form.setVisible(false);
            phoneChange_form.setVisible(false);
            address_change_form.setVisible(false);
        }
        if (event.getSource() == order_btn) {
            home_form.setVisible(false);
            about_us_form.setVisible(false);
            orders_form.setVisible(true);
            account_form.setVisible(false);
            shopping_cart_form.setVisible(false);
            phoneChange_form.setVisible(false);
            address_change_form.setVisible(false);
        }
        if (event.getSource() == account_btn) {
            home_form.setVisible(false);
            about_us_form.setVisible(false);
            orders_form.setVisible(false);
            account_form.setVisible(true);
            shopping_cart_form.setVisible(false);
            phoneChange_form.setVisible(false);
            address_change_form.setVisible(false);
        }
        if (event.getSource() == cart_btn) {
            home_form.setVisible(false);
            about_us_form.setVisible(false);
            orders_form.setVisible(false);
            account_form.setVisible(false);
            shopping_cart_form.setVisible(true);
            phoneChange_form.setVisible(false);
            address_change_form.setVisible(false);
        }
        if (event.getSource() == continue_shopping_btn) {
            home_form.setVisible(true);
            about_us_form.setVisible(false);
            orders_form.setVisible(false);
            account_form.setVisible(false);
            shopping_cart_form.setVisible(false);
            phoneChange_form.setVisible(false);
            address_change_form.setVisible(false);
        }
        if (event.getSource() == change_phone_btn) {
            home_form.setVisible(false);
            about_us_form.setVisible(false);
            orders_form.setVisible(false);
            account_form.setVisible(false);
            shopping_cart_form.setVisible(false);
            phoneChange_form.setVisible(true);
            address_change_form.setVisible(false);
        }
        if (event.getSource() == go_backPhone_btn) {
            home_form.setVisible(false);
            about_us_form.setVisible(false);
            orders_form.setVisible(false);
            account_form.setVisible(true);
            shopping_cart_form.setVisible(false);
            phoneChange_form.setVisible(false);
            address_change_form.setVisible(false);
        }
        if (event.getSource() == change_address_btn) {
            home_form.setVisible(false);
            about_us_form.setVisible(false);
            orders_form.setVisible(false);
            account_form.setVisible(false);
            shopping_cart_form.setVisible(false);
            phoneChange_form.setVisible(false);
            address_change_form.setVisible(true);
        }
        if (event.getSource() == go_backAddress_btn) {
            home_form.setVisible(false);
            about_us_form.setVisible(false);
            orders_form.setVisible(false);
            account_form.setVisible(true);
            shopping_cart_form.setVisible(false);
            phoneChange_form.setVisible(false);
            phoneChange_form.setVisible(false);
            address_change_form.setVisible(false);
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

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        displayAddress();
    }
}
