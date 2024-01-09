package com.jmc.groceryapp.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    public TextField username_field;
    public PasswordField passwordField;
    public Button dont_account_btn;
    public Button sign_in_btn;
    public AnchorPane sign_in_form;
    public AnchorPane sign_up_form;
    public TextField name_field;
    public TextField surname_field;
    public TextField phoneNumber_signUp_field;
    public TextField email_field;
    public TextField password_signUp_TxtField;
    public PasswordField password_signUpField;
    public TextField confirmPasswordTxtField;
    public PasswordField confirmPasswordField;
    public Button sign_up_btn;
    public Button already_account_btn;
    public TextField password_signIn_TxtField;

    private Stage signUpStage;

    public void switchForm(ActionEvent event) {
        if (event.getSource() == already_account_btn) {
            sign_up_form.setVisible(false);
            sign_in_form.setVisible(true);
        }
        if (event.getSource() == dont_account_btn) {
            sign_up_form.setVisible(true);
            sign_in_form.setVisible(false);
        }
    }

    public void signUp_btn(ActionEvent event) throws IOException {
        String name = name_field.getText();
        String surname = surname_field.getText();
        String phoneNumber = phoneNumber_signUp_field.getText();
        String email = email_field.getText();
        String password = password_signUpField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showErrorAlert("Please Fill All Blank Fields");
        } else {
            if (password.length() < 8) {
                showErrorAlert("Your password should be at least 8 characters long");
            } else {

                boolean registrationSuccess = registerUser(email, password);

                if (registrationSuccess) {
                    showInfoAlert("Successfully Registered!");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CustomerForm.fxml"));
                    Parent root = loader.load();

                    signUpStage = new Stage();
                    signUpStage.setTitle("Main Form");
                    signUpStage.initModality(Modality.APPLICATION_MODAL);
                    signUpStage.setScene(new Scene(root));


                    signUpStage.show();
                } else {
                    showErrorAlert("Registration failed. Please try again.");
                }

                // Clear input fields
                email_field.clear();
                password_signUpField.clear();
                confirmPasswordField.clear();
            }
        }
    }

    public void logIn_btn(ActionEvent event) throws IOException {
        String email = username_field.getText();
        String password = password_signUpField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showErrorAlert("Please Fill All Blank Fields");
        } else {
            if (password.length() < 8) {
                showErrorAlert("Your password should be at least 8 characters long");
            } else {

                boolean registrationSuccess = registerUser(email, password);

                if (registrationSuccess) {
                    showInfoAlert("Successfully Registered!");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MainForm.fxml"));
                    Parent root = loader.load();

                    signUpStage = new Stage();
                    signUpStage.setTitle("Main Form");
                    signUpStage.initModality(Modality.APPLICATION_MODAL);
                    signUpStage.setScene(new Scene(root));


                    signUpStage.show();
                } else {
                    showErrorAlert("Registration failed. Please try again.");
                }

                // Clear input fields
                email_field.clear();
                password_signUpField.clear();
                confirmPasswordField.clear();
            }
        }
    }

    private boolean registerUser(String email, String password) {
        return true;
    }


    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
