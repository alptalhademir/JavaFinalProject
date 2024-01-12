package com.jmc.groceryapp.Controllers;

import com.jmc.groceryapp.Models.Customer;
import com.jmc.groceryapp.Models.Product;
import com.jmc.groceryapp.dao.CustomerDAO;
import com.jmc.groceryapp.dao.ProductDAO;
import com.jmc.groceryapp.dao.UserDAO;
import com.jmc.groceryapp.dao.impl.CustomerDAOImpl;
import com.jmc.groceryapp.dao.impl.UserDAOImpl;
import com.jmc.groceryapp.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;


public class MainFormController implements Initializable {
    public Button home_btn;
    public Button carrier_btn;
    public Button order_btn;
    public Button report_btn;
    public Button log_out_btn;
    public Button aboutUs_btn;
    public TableView<Product> product_table;
    public TableColumn<Product, Integer> product_id_col;
    public TableColumn<Product, String> product_name_col;
    public TableColumn<Product, Float> stock_col;
    public TableColumn<Product, Float> price_col;
    public TableColumn<Product, Float> threshold_col;
    public TableColumn<Product, Float> type_col;
    public TextField product_name_field;
    public TextField product_stock_field;
    public TextField product_price_field;
    public Button addProductBtn;
    public Button clearTextBtn;
    public ImageView product_image_viewer;
    public Button import_btn;
    public Button updateProductBtn;
    public TextField product_id_field;
    public AnchorPane home_form;
    public AnchorPane reports_form;
    public AnchorPane about_us_form;
    public Label hire_fire_lbl;
    public Label username_lbl;
    public TextField usernameTxt;
    public Label carrier_lbl;
    public TextField carrierTxt;
    public Label password_lbl;
    public TextField passwordTxt;
    public Button hire_btn;
    public Button fire_btn;
    public Button cancel_changes_btn;
    public Button save_btn;
    public TableView carrier_tableview;
    public TableColumn no_col;
    public TableColumn carrierID_col;
    public TableColumn username_col;
    public TableColumn password_col;
    public AnchorPane carriers_form;
    public AnchorPane order_form;
    public Label totalOrderLabel;
    public Label completedOrderLabel;
    public Label pendingOrderLabel;
    public Label canceledOrderLabel;
    public Label newOrderLabel;
    public TableView tableview;
    public TableColumn col_num;
    public TableColumn col_customerID;
    public TableColumn col_totalQuantity;
    public TableColumn col_totalPrice;
    public TableColumn col_date;
    public TableColumn col_status;
    public TableColumn col_carrierID;
    public VBox DetailTable;
    public TableView tableview_orderDetails;
    public TableColumn col_num1;
    public TableColumn col_customerID1;
    public TableColumn col_totalQuantity1;
    public TableColumn col_totalPrice1;
    public TableColumn col_date1;
    public TableColumn col_status1;
    public TableColumn col_carrierID1;

    public Label username;
    public TextField product_type_field;
    public TextField product_threshold_field;
    public AnchorPane main_form;
    public Button DeleteBtn;
    public Label number_of_customers_lbl;
    public AreaChart todayIncomeChart;
    public BarChart numberOfCustomersChart;
    public AreaChart address_chart;
    private Image image;
    private UserDAO userDao;
    private CustomerDAO customerDAO;
    private ProductDAO productDAO;
    private final DatabaseConnection dataBaseConnection= new DatabaseConnection();

    public MainFormController() {
        this.userDao = new UserDAOImpl(dataBaseConnection);
        this.customerDAO = new CustomerDAOImpl(dataBaseConnection, dataBaseConnection);
        //this.productDAO = new ProductDAOImpl(dataBaseConnection);
    }

    /*public void inventoryAddBtn() {

        if(product_id_field.getText().isEmpty()
                || product_name_field.getText().isEmpty()
                || product_type_field.getText().isEmpty()
                || product_stock_field.getText().isEmpty()
                || product_price_field.getText().isEmpty()
                || product_threshold_field.getText().isEmpty()
                || data.path == null) {

                showErrorAlert("Please Fill All Blank Fields");
        }
        else {

            handleSubmitButtonAction(new ActionEvent());
            showInfoAlert("Product Successfully Added!");
            inventoryShowData();
            inventoryClearBtn();
        }
    }*/

    public void inventoryUpdateBtn() {

        if(product_id_field.getText().isEmpty()
                || product_name_field.getText().isEmpty()
                || product_type_field.getText().isEmpty()
                || product_stock_field.getText().isEmpty()
                || product_price_field.getText().isEmpty()
                || product_threshold_field.getText().isEmpty()
                || data.path == null) {

            showErrorAlert("Please Fill All Blank Fields");
        }
        else {

            /*// perform update
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                    // perform update

                    showInfoAlert("Successfully Updated");
                    inventoryShowData();
                    inventoryClearBtn();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }

    public void inventoryDeleteBtn() {

        if(product_id_field.getText().isEmpty()
                || product_name_field.getText().isEmpty()
                || product_type_field.getText().isEmpty()
                || product_stock_field.getText().isEmpty()
                || product_price_field.getText().isEmpty()
                || product_threshold_field.getText().isEmpty()
                || data.path == null) {

            showErrorAlert("Please Fill All Blank Fields");
        }
        else {

            /*// perform update
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to update?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                    // perform update

                    showInfoAlert("Successfully Updated");
                    inventoryShowData();
                    inventoryClearBtn();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }

    public void inventoryClearBtn() {

        product_id_field.setText("");
        product_name_field.setText("");
        product_type_field.setText("");
        product_stock_field.setText("");
        product_price_field.setText("");
        product_threshold_field.setText("");
        data.path = "";
        product_image_viewer.setImage(null);

    }

    @FXML
    public void handleSubmitButtonAction(ActionEvent event) {

        int productId = Integer.parseInt(product_id_field.getText());
        String productName = product_name_field.getText();
        String type = product_type_field.getText();
        float stock = Float.parseFloat(product_stock_field.getText());
        float price = Float.parseFloat(product_price_field.getText());
        float threshold = Float.parseFloat(product_threshold_field.getText());

        Product product = new Product(productName, type, stock, price, threshold);

    }

    public void inventoryImportBtn() {
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image File", "*.png", "*.jpg"));

        File file = openFile.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            data.path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 200, 172, false, true);
            product_image_viewer.setImage(image);
        }
    }

    public ObservableList<Product> productObservableList() {

        ObservableList<Product> listData = FXCollections.observableArrayList();

        String mysql = "SELECT * FROM product";

        Product prodData;

        try {

            PreparedStatement preparedStatement = dataBaseConnection.getConnection().prepareStatement(mysql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                prodData = new Product(resultSet.getString("Name"), resultSet.getString("Type"), resultSet.getFloat("Price"), resultSet.getFloat("Stock"), resultSet.getFloat("Threshold"));
                listData.add(prodData);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<Product> inventoryListData;
    public void inventoryShowData() {

        inventoryListData = productObservableList();

        product_id_col.setCellValueFactory(new PropertyValueFactory<>("productID"));
        product_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
        stock_col.setCellValueFactory(new PropertyValueFactory<>("stock"));
        price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
        threshold_col.setCellValueFactory(new PropertyValueFactory<>("threshold"));

        product_table.setItems(inventoryListData);
    }

    public void inventorySelectData() {

        Product product =product_table.getSelectionModel().getSelectedItem();
        int num = product_table.getSelectionModel().getSelectedIndex();

        if((num - 1) < - 1 ) {
            Integer.parseInt(product_id_field.getText());
            product_name_field.setText(product.getName());
            product_type_field.setText(product.getType());
            Float.parseFloat(product_stock_field.getText());
            Float.parseFloat(product_price_field.getText());
            Float.parseFloat(product_threshold_field.getText());

            inventoryImportBtn();
        }

    }

    // display username of the admin
    public void displayUsername() {

        String user = data.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);
        username.setText(user);

    }

    // Switch different pages
    public void switchForm(ActionEvent event) {
        if (event.getSource() == report_btn) {
            reports_form.setVisible(true);
            home_form.setVisible(false);
            about_us_form.setVisible(false);
            order_form.setVisible(false);
            carriers_form.setVisible(false);
        }
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            reports_form.setVisible(false);
            about_us_form.setVisible(false);
            order_form.setVisible(false);
            carriers_form.setVisible(false);
        }
        if (event.getSource() == aboutUs_btn) {
            about_us_form.setVisible(true);
            home_form.setVisible(false);
            reports_form.setVisible(false);
            order_form.setVisible(false);
            carriers_form.setVisible(false);
        }
       if(event.getSource() == order_btn) {
            order_form.setVisible(true);
            about_us_form.setVisible(false);
            home_form.setVisible(false);
            reports_form.setVisible(false);
            carriers_form.setVisible(false);
        }
        if(event.getSource() == carrier_btn) {
            carriers_form.setVisible(true);
            about_us_form.setVisible(false);
            home_form.setVisible(false);
            reports_form.setVisible(false);
            order_form.setVisible(false);
        }
    }


    // Log out
    public void logout() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to log out?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.isPresent() && option.get().equals(ButtonType.OK)) {
                log_out_btn.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Register.fxml"));
                Parent root = loader.load();

                // Create a new stage
                Stage stage = new Stage();
                stage.setTitle("Register Form");
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Alert Functions
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

    // Reports
    public void displayCustomerCount() {
        int totalCustomers = customerDAO.getTotalCustomers();
        String customerCountText = String.valueOf(totalCustomers);
        number_of_customers_lbl.setText(customerCountText);
    }

    public void displayLineChart() {

        LineChart<String, Number> newLineChart = customerDAO.createLineChart();

        numberOfCustomersChart.getData().addAll(newLineChart.getData());
    }

    public void displayAddressGraph() {

        LineChart<String, Number> newLineChart = customerDAO.createLineChartAddress();

        address_chart.getData().addAll(newLineChart.getData());
    }



    //Hire-Fire Carrier



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        //inventoryShowData();
        displayCustomerCount();
        displayLineChart();
        displayAddressGraph();

    }
}
