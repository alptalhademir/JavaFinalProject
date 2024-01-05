package com.jmc.groceryapp.Controllers.Client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class cardProductController implements Initializable {

    @FXML
    private AnchorPane card_form;

    @FXML
    private Button product_addbtn;

    @FXML
    private ImageView product_imageView;

    @FXML
    private Label product_name;

    @FXML
    private Label product_price;

    @FXML
    private Spinner<?> product_spinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
