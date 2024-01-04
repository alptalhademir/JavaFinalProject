package com.jmc.groceryapp.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private ChoiceBox<String> accSelector; // Assuming you want to store String values in the ChoiceBox
    @FXML
    private TextField emailAddressField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button signInBtn;
    @FXML
    private Button signUpBtn;
    @FXML
    private Label emailAddressLabel;
    @FXML
    private Label passwordLabel;

    // You can add an initialize method if you want to perform some actions when the controller is initialized
    @FXML
    private void initialize() {
        // Initialize the ChoiceBox with some options
        accSelector.getItems().addAll("Option 1", "Option 2", "Option 3");
    }

    // Add event handlers for the buttons or any other controls as needed
    @FXML
    private void handleSignInButtonAction() {
        // Implement the logic for handling sign-in button click
        String email = emailAddressField.getText();
        String password = passwordField.getText();
        // Perform authentication and other actions
        System.out.println("Sign In Button Clicked");
    }

    @FXML
    private void handleSignUpButtonAction() {
        // Implement the logic for handling sign-up button click
        // You can navigate to a signup screen or perform other actions
        System.out.println("Sign Up Button Clicked");
    }
}
