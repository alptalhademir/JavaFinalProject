package com.jmc.groceryapp.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    public TextField email_address_field;
    public PasswordField password_field;
    public Button signup_btn;
    public Button signin_btn;
    public Label email_address_label;
    public Label password_lbl;
    public TextField name_field;
    public TextField surname_field;
    public Label surname_lbl;
    public Label name_lbl;
    public TextField phone_field;
    public Label phone_lbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signin_btn.setOnAction(event -> openLogInPage());
    }

    private void openLogInPage() {
        try {
            // Load the sign-up page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
            Parent root = loader.load();

            Stage stage = null;
            // Create a new stage
            stage = new Stage();
            stage.setTitle("Log in");
            stage.setScene(new Scene(root));

            // Show the sign-up page
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }
}
