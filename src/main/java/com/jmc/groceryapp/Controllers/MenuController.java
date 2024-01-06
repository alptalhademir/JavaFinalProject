package com.jmc.groceryapp.Controllers;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MenuController {
    public Text customer_name;
    public Button contact_btn;
    public Button aboutUs_btn;
    public Button logout_btn;
    public Button account_btn;
    public Button orders_btn;
    public Button chart_btn;
    public Button home_btn;
    public Button receipt_btn;
    public Button remove_btn;
    public Button pay_btn;
    public Label menu_vat;
    public Label menu_total;
    public TableColumn menu_table_col_price;
    public TableColumn menu_table_col_quantity;
    public TableColumn menu_table_col_product;
    public TableView menu_tableView;
    public GridPane menu_gridPane;
    public ScrollPane menu_scrollPane;
    public AnchorPane menu_form;
}
