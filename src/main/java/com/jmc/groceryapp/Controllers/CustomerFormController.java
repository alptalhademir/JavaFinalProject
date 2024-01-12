package com.jmc.groceryapp.Controllers;

import com.jmc.groceryapp.Models.Product;
import com.jmc.groceryapp.dao.CustomerDAO;
import com.jmc.groceryapp.dao.ProductDAO;
import com.jmc.groceryapp.dao.UserDAO;
import com.jmc.groceryapp.dao.impl.CustomerDAOImpl;
import com.jmc.groceryapp.dao.impl.ProductDAOImpl;
import com.jmc.groceryapp.dao.impl.UserDAOImpl;
import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    @FXML
    private Button aboutUs_btn;

    @FXML
    private AnchorPane about_us_form;

    @FXML
    private Button account_btn;

    @FXML
    private AnchorPane account_form;

    @FXML
    private Button add_btn;

    @FXML
    private Label address_addressChange_lbl;

    @FXML
    private AnchorPane address_change_form;

    @FXML
    private Label address_lbl;

    @FXML
    private Label address_phoneChange_lbl;

    @FXML
    private Button cancel_order_btn;

    @FXML
    private Label canceledOrderLabel;

    @FXML
    private Button cart_btn;

    @FXML
    private TableView<?> cart_details_table;

    @FXML
    private Button change_address_btn;

    @FXML
    private Button change_phone_btn;

    @FXML
    private ScrollPane scroll_pane;

    @FXML
    private TableColumn<?, ?> col_amount;

    @FXML
    private TableColumn<?, ?> col_date;

    @FXML
    private TableColumn<?, ?> col_num;

    @FXML
    private TableColumn<?, ?> col_number;

    @FXML
    private TableColumn<?, ?> col_orderID;

    @FXML
    private TableColumn<?, ?> col_price;

    @FXML
    private TableColumn<?, ?> col_productName;

    @FXML
    private TableColumn<?, ?> col_status;

    @FXML
    private TableColumn<?, ?> col_totalPrice;

    @FXML
    private TableColumn<?, ?> col_totalQuantity;

    @FXML
    private Label completedOrderLabel;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField confirmPasswordTxtField;

    @FXML
    private PasswordField confirmPassword_AddressField;

    @FXML
    private TextField confirmPassword_AddressTxtField;

    @FXML
    private PasswordField confirmPassword_PhoneField;

    @FXML
    private TextField confirmPassword_PhoneTxtField;

    @FXML
    private Button confirm_Phone_btn;

    @FXML
    private Button confirm_Phone_btn1;

    @FXML
    private Button confirm_btn;

    @FXML
    private Button confirm_order_btn;

    @FXML
    private Button continue_shopping_btn;

    @FXML
    private TextField currentAddressTxtField;

    @FXML
    private PasswordField currentPasswordField;

    @FXML
    private TextField currentPasswordTxtField;

    @FXML
    private TextField currentPasswordTxtField1;

    @FXML
    private DatePicker delivery_datepicker;

    @FXML
    private Button go_backAddress_btn;

    @FXML
    private Button go_backPhone_btn;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Button log_out_btn;

    @FXML
    private TextField newAddressxtField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private TextField newPasswordTxtField;

    @FXML
    private TextField newPhoneTxtField;

    @FXML
    private Button order_btn;

    @FXML
    private AnchorPane orders_form;

    @FXML
    private TableView<?> past_purchase_table;

    @FXML
    private Button pay_btn;

    @FXML
    private Label pendingOrderLabel;

    @FXML
    private AnchorPane phoneChange_form;

    @FXML
    private Label phone_addressChange_lbl;

    @FXML
    private Label phone_label;

    @FXML
    private Label phone_phoneChange_lbl;

    @FXML
    private AnchorPane product_viewer;

    @FXML
    private Button remove_btn;

    @FXML
    private Button resetBtn;

    @FXML
    private AnchorPane shopping_cart_form;

    @FXML
    private Label subtotal_lbl;

    @FXML
    private Label totalOrderLabel;

    @FXML
    private Label total_lbl;

    @FXML
    private Label username;

    @FXML
    private Label username_addressChange_lbl;

    @FXML
    private Label username_lbl;

    @FXML
    private Label username_phoneChange_lbl;

    @FXML
    private Label vat_lbl;
    private UserDAO userDao;
    private CustomerDAO customerDAO;

    cardController cardController = new cardController();

    ProductDAO productDAO = new ProductDAOImpl(new DatabaseConnection());




    private ObservableList<Product> products=productDAO.getAllProducts();

    private final DatabaseConnection dataBaseConnection= new DatabaseConnection();

    public CustomerFormController() {
        this.userDao = new UserDAOImpl(dataBaseConnection);
        this.customerDAO = new CustomerDAOImpl(dataBaseConnection, dataBaseConnection);
        this.productDAO = new ProductDAOImpl(dataBaseConnection);
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
            phone_label.setText(user);
        } else {

            phone_label.setText("N/A");
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

        ProductDAO productDAO = new ProductDAOImpl(new DatabaseConnection());
        ObservableList<Product> products = productDAO.getAllProducts();

        VBox vbox = new VBox();
        for (Product product : products) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/cardProduct.fxml"));
                Node cardProduct = loader.load();

                cardController cardController = loader.getController();
                cardController.setProduct(product);

                vbox.getChildren().add(cardProduct);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scroll_pane.setContent(vbox);

    }
}
