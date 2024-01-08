package com.jmc.groceryapp.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    private Alert alert;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signin_btn.setOnAction(event -> openLogInPage());
    }

    public void signup_btn() {
        if (email_address_field.getText().isEmpty() || password_field.getText().isEmpty() || name_field.getText().isEmpty() || surname_field.getText().isEmpty() || phone_field.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All Blank Fields");
            alert.showAndWait();
        } else {
            try {
                // Check password length
                if (password_field.getText().length() < 8) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Your password should be at least 8 characters long");
                    alert.showAndWait();
                } else {
                    // Uncomment the database connection part and handle it properly

                    // Perform the database insert
                    /*prepare = connect.prepareStatement(regData);
                    prepare.setString(1, name_field.getText());
                    prepare.setString(2, surname_field.getText());
                    prepare.setString(3, phone_field.getText());
                    prepare.setString(4, email_address_field.getText());
                    prepare.setString(5, password_field.getText());

                    prepare.executeUpdate();*/

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Registered Account!");
                    alert.showAndWait();

                    email_address_field.setText("");
                    password_field.setText("");
                }

            } catch (Exception e) {
                // Handle exceptions more gracefully, e.g., show an error message to the user
                e.printStackTrace();
            }
        }
    }
    private void openLogInPage() {
        try {
            // Load the sign-up page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Register.fxml"));
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
