package com.jmc.groceryapp.Controllers;

import com.jmc.groceryapp.Models.Customer;
import com.jmc.groceryapp.dao.CustomerDAO;
import com.jmc.groceryapp.dao.UserDAO;
import com.jmc.groceryapp.dao.impl.CustomerDAOImpl;
import com.jmc.groceryapp.dao.impl.UserDAOImpl;
import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import java.time.LocalDate;
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
    public TextField password_signUp_TxtField;
    public PasswordField password_signUpField;
    public Button sign_up_btn;
    public Button already_account_btn;
    public TextField password_signIn_TxtField;
    public TextField address_field;
    public TextField username_signUp_field;
    private UserDAO userDao;
    private CustomerDAO customerDAO;
    private final DatabaseConnection dataBaseConnection= new DatabaseConnection();

    public RegisterController() {
        this.userDao = new UserDAOImpl(dataBaseConnection);
        this.customerDAO = new CustomerDAOImpl(dataBaseConnection, dataBaseConnection);
    }

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

    public void handleSubmitButtonAction(ActionEvent event) throws IOException {
        String firstName = name_field.getText();
        String lastName = surname_field.getText();
        String userName = username_signUp_field.getText();
        String address = address_field.getText();
        String password = password_signUpField.getText();
        String phoneNumber = phoneNumber_signUp_field.getText();

        if (firstName.isEmpty() || password.isEmpty() || lastName.isEmpty() || userName.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
            showErrorAlert("Please Fill All Blank Fields!");
        }
        else if (password.length() < 8) {
            showErrorAlert("Your password should be at least 8 characters long");
        }
        /*else if (!password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*")) {
            showErrorAlert("Your password should include both uppercase and lowercase characters");
        }
        else if (!password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            showErrorAlert("Your password should include numbers and special characters");
        }*/
        else {
            try {

                if (userDao.doesUsernameExist(userName)) {
                    showErrorAlert("Username is already taken");
                    return;
                }

                LocalDate creationDate = LocalDate.now();
                Customer customer = new Customer(firstName, lastName, userName, password, "Customer", address, phoneNumber, creationDate);
                userDao.addUser(customer);
                customerDAO.addCustomer(customer);

                data.username = userName;
                data.address = address;

                showInfoAlert();


                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CustomerForm.fxml"));
                Parent root = loader.load();

                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();

                Stage customerFormStage = new Stage();
                customerFormStage.setTitle("Customer Form");
                customerFormStage.initModality(Modality.APPLICATION_MODAL);
                customerFormStage.setScene(new Scene(root));
                customerFormStage.show();

            } catch (Exception e) {
                showErrorAlert("An error occurred. Please try again.");
                e.printStackTrace();
            }
        }

        name_field.clear();
        surname_field.clear();
        username_signUp_field.clear();
        address_field.clear();
        password_signUpField.clear();
        phoneNumber_signUp_field.clear();
    }

    public void logIn_btn(ActionEvent event) throws IOException {
        String username = username_field.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showErrorAlert("Please Fill All Blank Fields");
        } else {
            if (password.length() < 8) {
                showErrorAlert("Your password should be at least 8 characters long");
            } else {
                try {

                    if (!userDao.doesUsernameExist(username)) {
                        showErrorAlert("Check your username or password");
                        return;
                    }
                    else if(username.equals("admin"))
                    {
                        data.username = username;
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/MainForm.fxml"));
                        Parent root = loader.load();

                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        currentStage.close();

                        Stage customerFormStage = new Stage();
                        customerFormStage.setTitle("Admin Form");
                        customerFormStage.initModality(Modality.APPLICATION_MODAL);
                        customerFormStage.setScene(new Scene(root));
                        customerFormStage.show();
                    }
                    else {

                        data.username = username;
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CustomerForm.fxml"));
                        Parent root = loader.load();

                        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        currentStage.close();

                        Stage customerFormStage = new Stage();
                        customerFormStage.setTitle("Customer Form");
                        customerFormStage.initModality(Modality.APPLICATION_MODAL);
                        customerFormStage.setScene(new Scene(root));
                        customerFormStage.show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        username_field.clear();
        passwordField.clear();
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Successfully Registered!");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

