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
    private Text customer_name;

    @FXML
    private AnchorPane menu_form;

    @FXML
    private GridPane menu_gridPane;

    @FXML
    private ScrollPane menu_scrollPane;

    @FXML
    private TableView<MenuItem> menu_tableView; // Replace with the actual type of your data model (e.g., MenuItem)

    @FXML
    private TableColumn<MenuItem, Double> menu_table_col_price; // Replace with the actual type of your data model for the price (e.g., Double)

    @FXML
    private TableColumn<MenuItem, String> menu_table_col_product; // Replace with the actual type of your data model for the product name (e.g., String)

    @FXML
    private TableColumn<MenuItem, Integer> menu_table_col_quantity; // Replace with the actual type of your data model for the quantity (e.g., Integer)

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

    public void MenuDisplayCard() {
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
    }
}
