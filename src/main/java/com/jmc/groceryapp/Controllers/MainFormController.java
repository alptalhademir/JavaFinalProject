package com.jmc.groceryapp.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public Button home_btn;
    public Button carrier_btn;
    public Button order_btn;
    public Button report_btn;
    public Button log_out_btn;
    public Button aboutUs_btn;
    public TableView<?> product_table;  // Specify the type for TableView
    public TableColumn<?, ?> product_id_col;
    public TableColumn<?, ?> product_name_col;
    public TableColumn<?, ?> stock_col;
    public TableColumn<?, ?> price_col;
    public TableColumn<?, ?> date_col;
    public TextField product_name_field;
    public TextField product_stock_field;
    public TextField product_price_field;
    public Button addProductBtn;
    public Button clearTextBtn;
    public ImageView product_image_viewer;
    public Button import_btn;
    public Button updateProductBtn;
    public Button saveBtn;  // Change SaveBtn to camelCase
    public Button cancel_change_btn;
    public TextField product_id_field;
    public AnchorPane home_form;
    public AnchorPane reports_form;
    public Button SaveBtn;
    public AnchorPane about_us_form;
    public TableView tableview;
    public TableColumn col_num;
    public TableColumn col_customerID;
    public TableColumn col_totalPrice;
    public TableColumn col_date;
    public TableColumn col_status;
    public Label totalOrderLabel;
    public Label completedOrderLabel;
    public Label pendingOrderLabel;
    public Label canceledOrderLabel;
    public Label newOrderLabel;
    public VBox DetailTable;
    public TableColumn col_DPrice;
    public TableColumn col_DQuantity;
    public TableColumn col_DTotalPrice;
    public AnchorPane order_form;
    public TableColumn col_productID;
    public TableColumn carrier_col;
    public TableView orderdetails;
    public TableColumn customerID_col;
    public TableColumn pruductID_col;
    public TableColumn number_col;

    private Alert alert;

    public void switchForm(ActionEvent event) {
        if (event.getSource() == report_btn) {
            home_form.setVisible(false);
            reports_form.setVisible(true);
            about_us_form.setVisible(false);
            order_form.setVisible(false);
        }
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            reports_form.setVisible(false);
            about_us_form.setVisible(false);
            order_form.setVisible(false);
        }
        if (event.getSource() == aboutUs_btn) {
            about_us_form.setVisible(true);
            home_form.setVisible(false);
            reports_form.setVisible(false);
            order_form.setVisible(false);
        }
        if(event.getSource() == order_btn) {
            about_us_form.setVisible(false);
            home_form.setVisible(false);
            reports_form.setVisible(false);
            order_form.setVisible(true);
        }
    }

    public void logout() {
        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to log out?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                log_out_btn.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
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
        // Initialization code, if needed
    }
}
