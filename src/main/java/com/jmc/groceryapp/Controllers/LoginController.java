package com.jmc.groceryapp.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    public ChoiceBox<String> acc_selector;
    public TextField email_address_field;
    public PasswordField password_field;
    public Button sign_btn;
    public Button signup_btn;
    public Label email_address_label;
    public Label password_lbl;

    private Alert alert;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        acc_selector.getItems().addAll("Customer", "Carrier", "Owner");

        acc_selector.setValue("Customer");

        signup_btn.setOnAction(event -> openSignUpPage());
    }

    // if chose customer
    // if chose carrier
    //if chose owner

    public void sign_btn () {
            if( acc_selector.getItems().isEmpty() || email_address_field.getText().isEmpty() || password_field.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please Fill All Blank Fields");
                alert.showAndWait();
            }
            else {
                // write into the database
            }
    }
    private void openSignUpPage() {
        try {
            // Load the sign-up page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Signup.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Sign Up");
            stage.setScene(new Scene(root));

            // Show the sign-up page
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }
}
