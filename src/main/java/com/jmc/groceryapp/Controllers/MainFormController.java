package com.jmc.groceryapp.Controllers;

import com.jmc.groceryapp.Models.Carrier;
import com.jmc.groceryapp.Models.Product;
import com.jmc.groceryapp.dao.CarrierDAO;
import com.jmc.groceryapp.dao.CustomerDAO;
import com.jmc.groceryapp.dao.ProductDAO;
import com.jmc.groceryapp.dao.UserDAO;
import com.jmc.groceryapp.dao.impl.CarrierDAOImpl;
import com.jmc.groceryapp.dao.impl.CustomerDAOImpl;
import com.jmc.groceryapp.dao.impl.ProductDAOImpl;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class MainFormController implements Initializable {
    public Button home_btn;
    public Button carrier_btn;
    public Button order_btn;
    public Button report_btn;
    public Button log_out_btn;
    public Button aboutUs_btn;
    public TableColumn<Product, String> product_id_col;
    public TableColumn<Product, String> product_name_col;
    public TableColumn<Product, Double> stock_col;
    public TableColumn<Product, Double> price_col;
    public TableColumn<Product, Double> threshold_col;
    public TableColumn<Product, Double> type_col;
    public TextField product_name_field;
    public TextField product_stock_field;
    public TextField product_price_field;
    public ImageView product_image_viewer;
    public Button import_btn;
    public Button updateProductBtn;
    public AnchorPane home_form;
    public AnchorPane reports_form;
    public AnchorPane about_us_form;
    public Label hire_fire_lbl;
    public Label username_lbl;
    public TextField usernameTxt;
    public Label password_lbl;
    public TableView<Carrier> carrier_tableview;
    public TableColumn no_col;
    public TableColumn carrierID_col;
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
    public Label number_of_customers_lbl;
    public BarChart numberOfCustomersChart;
    public AreaChart address_chart;
    public Button delete_btn;
    public Button add_btn;
    public Button clear_btn;
    public TableView<Product> table_viewProduct;
    public PasswordField passwordField;
    public TextField name_field;
    public TextField surname_field;
    public TextField phone_field;
    public Button clear_carrier_btn;
    public Button carrier_fire_btn;
    public Button carrier_hire_btn;
    public TableColumn<Carrier, String> col_username;
    public TableColumn<Carrier, String> col_password;
    public Button update_btn;
    public Label total_veggies_lbl;
    public Label total_fruits_lbl;
    public Label totoal_carriers_lbl;
    private Image image;
    private UserDAO userDao;
    private CustomerDAO customerDAO;

    private CarrierDAO carrierDAO;

    private ProductDAO productDAO;
    private final DatabaseConnection dataBaseConnection= new DatabaseConnection();

    public MainFormController() {
        this.userDao = new UserDAOImpl(dataBaseConnection);
        this.customerDAO = new CustomerDAOImpl(dataBaseConnection, dataBaseConnection);
        this.productDAO = new ProductDAOImpl(dataBaseConnection);
        this.carrierDAO = new CarrierDAOImpl(dataBaseConnection, dataBaseConnection);
    }

    public void inventoryAddBtn() {
        if (areFieldsEmpty() || data.path == null) {
            showErrorAlert("Please Fill All Blank Fields");
        } else {
            handleSubmitButtonAction(new ActionEvent());
            showInfoAlert("Product Successfully Added!");
            inventoryShowData();
            inventoryClearBtn();
            displayVeggierCount();
            displayFruitCount();
        }
    }

    public void inventoryUpdateBtn() {
        if (areFieldsEmpty()) {
            showErrorAlert("Please Fill All Blank Fields");
        } else {
            if (showConfirmationDialog("Are you sure you want to update?")) {
                updateProductAndShowInfo();
            }
        }
    }

    public void inventoryDeleteBtn() {
            if (showConfirmationDialog("Are you sure you want to delete?")) {
                deleteProductAndShowInfo();
            }
    }

    public void updateProductAndShowInfo() {
        try {
            Product selectedProduct = table_viewProduct.getSelectionModel().getSelectedItem();
            if (selectedProduct != null) {
                productDAO.updateProduct(selectedProduct);
                showInfoAlert("Successfully Updated");
                inventoryShowData();
                inventoryClearBtn();
            } else {
                showErrorAlert("Please select a product to update");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProductAndShowInfo() {
        try {
            Product selectedProduct = table_viewProduct.getSelectionModel().getSelectedItem();
            if (selectedProduct != null) {
                if (showConfirmationDialog("Are you sure you want to delete this product?")) {

                    productDAO.deleteProduct(selectedProduct);
                    showInfoAlert("Successfully Deleted");
                    inventoryShowData();
                    inventoryClearBtn();
                    displayVeggierCount();
                    displayFruitCount();
                }
            } else {
                showErrorAlert("Please select a product to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error deleting product");
        }
    }

    public boolean areFieldsEmpty() {
        return product_name_field.getText().isEmpty()
                || product_type_field.getText().isEmpty()
                || product_stock_field.getText().isEmpty()
                || product_price_field.getText().isEmpty()
                || product_threshold_field.getText().isEmpty();
    }

    @FXML
    public void handleSubmitButtonAction(ActionEvent event) {

        int productId = 0;
        String productName = product_name_field.getText();
        String type = product_type_field.getText();
        Double stock = Double.parseDouble(product_stock_field.getText());
        Double price = Double.parseDouble(product_price_field.getText());
        Double threshold = Double.parseDouble(product_threshold_field.getText());

        Product product = new Product(productId, productName, type, stock, price, threshold);
        productDAO.addProduct(product);
    }

    public void inventoryClearBtn() {

        product_name_field.setText("");
        product_type_field.setText("");
        product_stock_field.setText("");
        product_price_field.setText("");
        product_threshold_field.setText("");
        data.path = "";
        product_image_viewer.setImage(null);

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

    private ObservableList<Product> inventoryListData;

    public void inventoryShowData() {
        try {
            List<Product> productList = productDAO.getAllProducts();
            System.out.println("Number of products retrieved: " + productList.size());
            inventoryListData = FXCollections.observableArrayList(productList);

            TableColumn<Product, Integer> product_id_col = new TableColumn<>("Product ID");
            TableColumn<Product, String> product_name_col = new TableColumn<>("Name");
            TableColumn<Product, String> type_col = new TableColumn<>("Type");
            TableColumn<Product, Double> stock_col = new TableColumn<>("Stock");
            TableColumn<Product, Double> price_col = new TableColumn<>("Price");
            TableColumn<Product, Double> threshold_col = new TableColumn<>("Threshold");

            product_id_col.setCellValueFactory(new PropertyValueFactory<>("productID"));
            product_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
            type_col.setCellValueFactory(new PropertyValueFactory<>("type"));
            stock_col.setCellValueFactory(new PropertyValueFactory<>("stock"));
            price_col.setCellValueFactory(new PropertyValueFactory<>("price"));
            threshold_col.setCellValueFactory(new PropertyValueFactory<>("threshold"));

            if (!table_viewProduct.getColumns().isEmpty()) {
                table_viewProduct.getColumns().clear();
            }

            table_viewProduct.setItems(inventoryListData);

            table_viewProduct.getColumns().addAll(
                    product_id_col,
                    product_name_col,
                    type_col,
                    stock_col,
                    price_col,
                    threshold_col
            );

            table_viewProduct.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inventorySelectData() {
        Product product = table_viewProduct.getSelectionModel().getSelectedItem();
        int num = table_viewProduct.getSelectionModel().getSelectedIndex();

        if (num >= 0) {
            product_name_field.setText(product.getName());
            product_type_field.setText(product.getType());

            try {
                String stockText = product_stock_field.getText().trim();
                String priceText = product_price_field.getText().trim();
                String thresholdText = product_threshold_field.getText().trim();

                if (!stockText.isEmpty() && !priceText.isEmpty() && !thresholdText.isEmpty()) {
                    double stock = Double.parseDouble(stockText);
                    double price = Double.parseDouble(priceText);
                    double threshold = Double.parseDouble(thresholdText);

                    product.setStock(stock);
                    product.setPrice(price);
                    product.setThreshold(threshold);

                    inventoryUpdateBtn();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
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

    private boolean showConfirmationDialog(String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        Optional<ButtonType> option = alert.showAndWait();
        return option.isPresent() && option.get().equals(ButtonType.OK);
    }

    // Reports
    public void displayCustomerCount() {
        int totalCustomers = customerDAO.getTotalCustomers();
        String customerCountText = String.valueOf(totalCustomers);
        number_of_customers_lbl.setText(customerCountText);
    }

    public void displayVeggierCount() {
        int totalVeggie = productDAO.getTotalVegetables();
        String totalVeggieCountText = String.valueOf(totalVeggie);
        total_veggies_lbl.setText(totalVeggieCountText);
    }

    public void displayFruitCount() {
        int totalFruits = productDAO.getTotalFruits();
        String totalFruitCountText = String.valueOf(totalFruits);
        total_fruits_lbl.setText(totalFruitCountText);
    }

    public void displayCarrierCount() {
        int totalCarriers = carrierDAO.getTotalCarriers();
        String totalCarrierCountText = String.valueOf(totalCarriers);
        totoal_carriers_lbl.setText(totalCarrierCountText);
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

    public boolean areFieldsEmptyCarrier() {
        return name_field.getText().isEmpty()
                || surname_field.getText().isEmpty()
                || phone_field.getText().isEmpty()
                || usernameTxt.getText().isEmpty()
                || passwordField.getText().isEmpty();
    }


        public void hireCarrier() {
        if (areFieldsEmptyCarrier()) {
            showErrorAlert("Please Fill All Blank Fields");
        } else {
            handeHireButtonAction(new ActionEvent());
            showInfoAlert("Carrier Successfully Added!");
            carrierDataShow();
            displayCarrierCount();
            btnClear();
        }
    }

    @FXML
    public void handeHireButtonAction(ActionEvent event) {
        String firstName = name_field.getText();
        String lastName = surname_field.getText();
        String userName = usernameTxt.getText();
        String password = passwordField.getText();
        String phoneNumber = phone_field.getText();

        LocalDate creationDate = LocalDate.now();
        Carrier carrier = new Carrier(firstName, lastName, userName, phoneNumber, password, creationDate);
        carrierDAO.addCarrier(carrier);
    }

    public void btnClear() {
        name_field.setText("");
        surname_field.setText("");
        phone_field.setText("");
        usernameTxt.setText("");
        passwordField.setText("");
    }

    public void handleFireButtonAction() {
        try {
            if (showConfirmationDialog("Are you sure you want to delete?")) {
                deleteCarrierAndShowInfo();
                carrierDataShow();
                displayCarrierCount();
                btnClear();
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error deleting carrier");
        }
    }


    public void deleteCarrierAndShowInfo() {
        try {
            Carrier selectedCarrier = carrier_tableview.getSelectionModel().getSelectedItem();
            if (selectedCarrier != null) {
                if (showConfirmationDialog("Are you sure you want to fire this carrier?")) {

                    carrierDAO.deleteCarrier(selectedCarrier);
                    showInfoAlert("Successfully Fired :(");
                    carrierDataShow();
                    inventoryClearBtn();
                }
            } else {
                showErrorAlert("Please select a carrier to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ObservableList<Carrier> carrierListData;

    public void carrierDataShow() {
        try {
            List<Carrier> carriers = carrierDAO.getAllCarriers();
            System.out.println("Number of carriers retrieved: " + carriers.size());
            carrierListData = FXCollections.observableArrayList(carriers);


            TableColumn<Carrier, String> userNameCol = new TableColumn<>("Username");
            TableColumn<Carrier, String> passwordCol = new TableColumn<>("Password");

            userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
            passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));

            if (!carrier_tableview.getColumns().isEmpty()) {
                carrier_tableview.getColumns().clear();
            }

            carrier_tableview.getColumns().addAll(
                    userNameCol,
                    passwordCol
            );

            carrier_tableview.setItems(carrierListData);

             carrier_tableview.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carrierUpdateBtn() {
        if (username.getText().isEmpty()) {
            showErrorAlert("Please Fill All Blank Fields");
        } else {
            if (showConfirmationDialog("Are you sure you want to update?")) {
                updateCarrierAndShowInfo();
            }
        }
    }

    public void updateCarrierAndShowInfo() {
        try {
            Carrier selectedCarrier = carrier_tableview.getSelectionModel().getSelectedItem();
            if (selectedCarrier != null) {

                carrierDAO.updateCarrier(selectedCarrier);
                showInfoAlert("Successfully Updated");
                carrierDataShow();
                btnClear();
            } else {
                showErrorAlert("Please select a carrier to update");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorAlert("Error updating carrier");
        }
    }

    public void carrierSelectData() {
        Carrier carrier = carrier_tableview.getSelectionModel().getSelectedItem();
        int num = carrier_tableview.getSelectionModel().getSelectedIndex();

        if (num >= 0 && carrier != null) {
            name_field.setText(carrier.getFirstName());
            surname_field.setText(carrier.getLastName());
            username.setText(carrier.getUserName());
            passwordField.setText(carrier.getPassword());

            try {

                String phoneNumberText = phone_field.getText().trim();

                if (!phoneNumberText.isEmpty()) {

                    String phoneNumber = String.valueOf(Double.parseDouble(phoneNumberText));


                    carrier.setPhoneNumber(phoneNumber);

                    carrierDAO.updateCarrier(carrier);

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();

            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        displayCustomerCount();
        displayVeggierCount();
        displayFruitCount();
        displayCarrierCount();
        displayLineChart();
        displayAddressGraph();
        inventoryShowData();
        carrierDataShow();
    }
}
