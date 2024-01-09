package com.jmc.groceryapp.Controllers;

import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Stage signUpStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acc_selector.getItems().addAll("Customer", "Carrier", "Owner");
        acc_selector.setValue("Customer");

        signup_btn.setOnAction(event -> openSignUpPage());
    }

    public void sign_btn() throws IOException {
        String accountType = acc_selector.getValue();
        String email = email_address_field.getText();
        String password = password_field.getText();

        if (accountType.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showErrorAlert("Please Fill All Blank Fields");
        } else {
            if (password.length() < 8) {
                showErrorAlert("Your password should be at least 8 characters long");
            } else {
                // Check login credentials and handle success
                boolean loginSuccess = authenticateUser(accountType, email, password);

                if (loginSuccess) {
                    showInfoAlert("Successfully Logged into your Account!");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MainForm.fxml"));
                    Parent root = loader.load();

                    signUpStage = new Stage();
                    signUpStage.setTitle("Sign Up");
                    signUpStage.initModality(Modality.APPLICATION_MODAL);
                    signUpStage.setScene(new Scene(root));
                    // Perform any additional actions upon successful login
                } else {
                    showErrorAlert("Invalid credentials. Please try again.");
                }

                // Clear input fields
                email_address_field.clear();
                password_field.clear();
            }
        }
    }

    private boolean authenticateUser(String accountType, String email, String password) {
        // Implement the logic to authenticate the user using the provided credentials
        // You may need to query the database or use any other authentication mechanism
        // For demonstration purposes, returning true for now
        return true;
    }

    private void showErrorAlert(String message) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoAlert(String message) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void openSignUpPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Signup.fxml"));
            Parent root = loader.load();

            signUpStage = new Stage();
            signUpStage.setTitle("Sign Up");
            signUpStage.initModality(Modality.APPLICATION_MODAL);
            signUpStage.setScene(new Scene(root));

            signUpStage.setOnCloseRequest(event -> {
                signUpStage.close();
                ((Stage) email_address_field.getScene().getWindow()).close();
            });

            signUpStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
