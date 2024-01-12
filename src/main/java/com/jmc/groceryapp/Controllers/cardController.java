package com.jmc.groceryapp.Controllers;

import com.jmc.groceryapp.Models.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class cardController {
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

    public void setProduct(Product product){
        product_name.setText(product.getName());
        product_price.setText(String.valueOf(product.getPrice()));
    }


}
