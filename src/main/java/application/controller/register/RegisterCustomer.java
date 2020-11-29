package application.controller.register;

import application.GlobalAccessVariables;
import application.data.Car;
import application.data.Customer;
import application.service.CustomerList;
import application.service.VehicleList;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterCustomer implements Initializable {

    @FXML
    JFXButton vehicleRegisterButton, customerRegisterButton, vehicleListButton, rentalButton, rentalListButton, customerListButton;
    @FXML
    JFXButton homeButton;

    public void handleButtonAction(javafx.event.ActionEvent event) throws Exception {
        Parent root;

        if (event.getSource() == vehicleRegisterButton) {
            root = FXMLLoader.load(getClass().getResource("/application/controller/register/registerVehicle.fxml"));
        } else if (event.getSource() == customerRegisterButton) {
            root = FXMLLoader.load(getClass().getResource("/application/controller/register/registerCustomer.fxml"));
        } else if (event.getSource() == vehicleListButton) {
            root = FXMLLoader.load(getClass().getResource("/application/controller/display/displayVehicle.fxml"));
        } else if (event.getSource() == rentalButton) {
            root = FXMLLoader.load(getClass().getResource("/application/controller/register/registerRental.fxml"));
        } else if (event.getSource() == rentalListButton) {
            root = FXMLLoader.load(getClass().getResource("/application/controller/display/displayRental.fxml"));
        } else if (event.getSource() == customerListButton) {
            root = FXMLLoader.load(getClass().getResource("/application/controller/display/displayCustomer.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("/application/controller/primaryView.fxml"));
        }
        GlobalAccessVariables.mainStage.getScene().setRoot(root);
    }

    CustomerList list = GlobalAccessVariables.customerList;

    @FXML
    TextField firstName;
    @FXML
    TextField lastName;
    @FXML
    TextField city;
    @FXML
    TextField street;
    @FXML
    TextField streetNumber;
    @FXML
    TextField postalCode;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField email;
    @FXML
    TextField dateOfBirth;
    @FXML
    JFXButton save;
    @FXML
    JFXButton clear;
    @FXML
    Label errorMessage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dateOfBirth.setPromptText("tt-mm-jjjj");

        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (firstName.getText().equals("")
                        || lastName.getText().equals("")
                        || city.getText().equals("")
                        || street.getText().equals("")
                        || streetNumber.getText().equals("")
                        || postalCode.getText().equals("")
                        || phoneNumber.getText().equals("")
                        || email.getText().equals("")
                        || dateOfBirth.getText().equals("")

                ) {
                    errorMessage.setText("Bitte jedes Feld ausfüllen!");
                    errorMessage.setVisible(true);
                } else {
                    errorMessage.setVisible(false);
                    Customer customer = new Customer();

                    String streetNrString = streetNumber.getText();
                    String postalString = postalCode.getText();
                    int streetNrConverted = Integer.parseInt(streetNrString);
                    int postalConverted = Integer.parseInt(postalString);

                    customer.setFirstName(firstName.getText());
                    customer.setLastName(lastName.getText());
                    customer.setCity(city.getText());
                    customer.setAddStreet(street.getText());
                    customer.setAddNumber(streetNrConverted);
                    customer.setAddPostalCode(postalConverted);
                    customer.setPhoneNumber(phoneNumber.getText());
                    customer.setEmail(email.getText());
                    customer.setDateOfBirth(dateOfBirth.getText());

                    list.addCustomer(customer);
                }
            }
        });
        //clears input fields
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                firstName.setText("");
                lastName.setText("");
                city.setText("");
                street.setText("");
                streetNumber.setText("");
                postalCode.setText("");
                phoneNumber.setText("");
                email.setText("");
                dateOfBirth.setText("");
            }
        });

    }
}
