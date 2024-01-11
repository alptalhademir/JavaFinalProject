package com.jmc.groceryapp.Controllers;

import com.jmc.groceryapp.Models.Customer;
import com.jmc.groceryapp.Models.User;
import com.jmc.groceryapp.dao.CustomerDAO;
import com.jmc.groceryapp.dao.UserDAO;
import com.jmc.groceryapp.dao.impl.CustomerDAOImpl;
import com.jmc.groceryapp.dao.impl.UserDAOImpl;
import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    public TextField address_field;
    @FXML
    public PasswordField password_field;
    @FXML
    public Button signup_btn;
    public Button signin_btn;
    public Label address_label;
    @FXML
    public TextField username_field;
    public Label username_lbl;
    public Label password_lbl;
    @FXML
    public TextField name_field;
    @FXML
    public TextField surname_field;
    public Label surname_lbl;
    public Label name_lbl;
    @FXML
    public TextField phone_field;
    public Label phone_lbl;

    private UserDAO userDao;
    private CustomerDAO customerDAO;

    private final DatabaseConnection dataBaseConnection= new DatabaseConnection();

    public SignupController() {
        this.userDao = new UserDAOImpl(dataBaseConnection);
        this.customerDAO = new CustomerDAOImpl(dataBaseConnection, dataBaseConnection);
    }

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

    @FXML
    public void handleSubmitButtonAction(ActionEvent event) {
        String firstName = name_field.getText();
        String lastName = surname_field.getText();
        String userName = username_field.getText();
        String adress = address_field.getText();
        String password = password_field.getText();
        String phoneNumber = phone_field.getText();

        LocalDate creationDate = LocalDate.now();
        Customer customer = new Customer(firstName, lastName, userName, password, "Customer", adress, phoneNumber, creationDate );
        userDao.addUser(customer);
        customerDAO.addCustomer(customer);
    }


      /*public void signUp_btn(ActionEvent event) {
        String name = name_field.getText();
        String surname = surname_field.getText();
        String phoneNumber = phoneNumber_signUp_field.getText();
        String email = email_field.getText();
        String password = password_signUpField.getText();

        if (email.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty() || phoneNumber.isEmpty()) {
            showErrorAlert("Please Fill All Blank Fields");
        } else if (password.length() < 8) {
            showErrorAlert("Your password should be at least 8 characters long");
        } else {
            handleSubmitButtonAction();

            if (registrationSuccess) {
                showInfoAlert();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CustomerForm.fxml"));
                    Parent root = loader.load();

                    signUpStage = new Stage();
                    signUpStage.setTitle("Main Form");
                    signUpStage.initModality(Modality.APPLICATION_MODAL);
                    signUpStage.setScene(new Scene(root));

                    signUpStage.show();

                } catch (IOException e) {
                    showErrorAlert("Error loading CustomerForm.fxml");
                    e.printStackTrace(); // Handle or log the exception appropriately
                }

                // Clear input fields
                email_field.clear();
                password_signUpField.clear();
                confirmPasswordField.clear();
            } else {
                showErrorAlert("Registration failed. Please try again.");
            }
        }
    }*/


    /*private boolean registerUser(String email, String password) {
        return true;
    }*/
}
