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
    public TextField confirmPassword_AddressTxtField;
    public PasswordField confirmPassword_AddressField;

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
