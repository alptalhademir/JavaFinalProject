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
    public Label hire_fire_lbl;
    public Label username_lbl;
    public TextField usernameTxt;
    public Label carrier_lbl;
    public TextField carrierTxt;
    public Label password_lbl;
    public TextField passwordTxt;
    public Button hire_btn;
    public Button fire_btn;
    public Button cancel_changes_btn;
    public Button save_btn;
    public TableView carrier_tableview;
    public TableColumn no_col;
    public TableColumn carrierID_col;
    public TableColumn username_col;
    public TableColumn password_col;
    public AnchorPane carriers_form;
    public AnchorPane order_form;
    public Label totalOrderLabel;
    public Label completedOrderLabel;
    public Label pendingOrderLabel;
    public Label canceledOrderLabel;
    public Label newOrderLabel;
    public TableView tableview;
    public TableColumn col_num;
    public TableColumn col_customerID;
    public TableColumn col_totalQuantity;
    public TableColumn col_totalPrice;
    public TableColumn col_date;
    public TableColumn col_status;
    public TableColumn col_carrierID;
    public VBox DetailTable;
    public TableView tableview_orderDetails;
    public TableColumn col_num1;
    public TableColumn col_customerID1;
    public TableColumn col_totalQuantity1;
    public TableColumn col_totalPrice1;
    public TableColumn col_date1;
    public TableColumn col_status1;
    public TableColumn col_carrierID1;

    private Alert alert;

    public void switchForm(ActionEvent event) {
        if (event.getSource() == report_btn) {
            reports_form.setVisible(true);
            home_form.setVisible(false);
            about_us_form.setVisible(false);
            order_form.setVisible(false);
            carriers_form.setVisible(false);
        }
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            reports_form.setVisible(false);
            about_us_form.setVisible(false);
            order_form.setVisible(false);
            carriers_form.setVisible(false);
        }
        if (event.getSource() == aboutUs_btn) {
            about_us_form.setVisible(true);
            home_form.setVisible(false);
            reports_form.setVisible(false);
            order_form.setVisible(false);
            carriers_form.setVisible(false);
        }
       if(event.getSource() == order_btn) {
            order_form.setVisible(true);
            about_us_form.setVisible(false);
            home_form.setVisible(false);
            reports_form.setVisible(false);
            carriers_form.setVisible(false);
        }
        if(event.getSource() == carrier_btn) {
            carriers_form.setVisible(true);
            about_us_form.setVisible(false);
            home_form.setVisible(false);
            reports_form.setVisible(false);
            order_form.setVisible(false);
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
        // Initialization code, if needed
    }
}
