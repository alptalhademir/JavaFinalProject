package com.jmc.groceryapp.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public AnchorPane menu_form;
    public ScrollPane menu_scrollPane;
    public GridPane menu_gridPane;
    public TableView menu_tableView;
    public TableColumn menu_table_col_product;
    public TableColumn menu_table_col_quantity;
    public TableColumn menu_table_col_price;
    public Label menu_total;
    public Label menu_vat;
    public Button pay_btn;
    public Button remove_btn;
    public Button receipt_btn;
    public Button home_btn;
    public Button chart_btn;
    public Button orders_btn;
    public Button account_btn;
    public Button logout_btn;
    public Button aboutUs_btn;
    public Button contact_btn;
    public Text customer_name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
