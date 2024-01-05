package com.jmc.groceryapp.Controllers.Client;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

// ... (import statements)

public class HomeController implements Initializable {

    @FXML
    private Button aboutUs_btn;

    @FXML
    private Button account_btn;

    @FXML
    private Button chart_btn;

    @FXML
    private Button contact_btn;

    @FXML
    private Text customer_name;

    @FXML
    private Button home_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane menu_form;

    @FXML
    private GridPane menu_gridPane;

    @FXML
    private ScrollPane menu_scrollPane;

    @FXML
    private TableView<?> menu_tableView;

    @FXML
    private TableColumn<?, ?> menu_table_col_price;

    @FXML
    private TableColumn<?, ?> menu_table_col_product;

    @FXML
    private TableColumn<?, ?> menu_table_col_quantity;

    @FXML
    private Label menu_total;

    @FXML
    private Label menu_vat;

    @FXML
    private Button orders_btn;

    @FXML
    private Button pay_btn;

    @FXML
    private Button receipt_btn;

    @FXML
    private Button remove_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /*public void MenuDisplayCard() {
        int row = 0;
        int column = 0;

        menu_gridPane.getRowConstraints().clear();
        menu_gridPane.getColumnConstraints().clear();

        for (int i = 0; i < 5; i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("cardProduct.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                cardProductController cardProductController = fxmlLoader.getController();

                if (column == 3) {
                    column = 0;
                    row += 1;
                }

                menu_gridPane.add(anchorPane, column++, row);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MenuDisplayCard();
    }*/
}
