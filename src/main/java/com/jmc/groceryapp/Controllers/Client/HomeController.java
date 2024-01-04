package com.jmc.groceryapp.Controllers.Client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class HomeController {

    @FXML
    private Text customer_name;

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
    private Button pay_btn;

    @FXML
    private Button receipt_btn;

    @FXML
    private Button remove_btn;

}
