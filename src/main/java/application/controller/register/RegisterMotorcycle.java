package application.controller.register;

import application.GlobalAccessVariables;
import application.data.Motorcycle;
import application.service.VehicleList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class RegisterMotorcycle implements Initializable {

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

    ObjectMapper objectMapper = new ObjectMapper();
    VehicleList list = GlobalAccessVariables.vehicleList;

    ObservableList<String> fuelTypeList = FXCollections.observableArrayList("Benzin", "Diesel", "Elektrisch");
    ObservableList<String> categoryList = FXCollections.observableArrayList("Basic", "Medium", "Luxus");
    ObservableList<String> statusList = FXCollections.observableArrayList("Verfügbar", "Nicht verfügbar", "Undefiniert");

    @FXML
    TextField vehicleBrand;
    @FXML
    TextField model;
    @FXML
    TextField ccm;
    @FXML
    ChoiceBox fuelTypeBox;
    @FXML
    TextField color;
    @FXML
    TextField licensePlate;
    @FXML
    TextField mileage;
    @FXML
    ChoiceBox categoryBox;
    @FXML
    TextField readyFrom;
    @FXML
    TextField readyTill;
    @FXML
    ChoiceBox statusBox;
    @FXML
    TextField fuelTank;
    @FXML
    JFXButton save;
    @FXML
    JFXButton clear;

    @FXML
    Label errorMessage;

    public void initialize(URL location, ResourceBundle resources) {

        readyFrom.setPromptText("tt-mm-jjjj");
        readyTill.setPromptText("tt-mm-jjjj");

        fuelTypeBox.setItems(fuelTypeList);
        categoryBox.setItems(categoryList);
        statusBox.setItems(statusList);

        //saves input to json, hopefully...  it jammers when an input field wasn't filled
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (vehicleBrand.getText().equals("")
                        || model.getText().equals("")
                        || ccm.getText().equals("")
                        || fuelTypeBox.getValue().equals("")
                        || color.getText().equals("")
                        || mileage.getText().equals("")
                        || licensePlate.getText().equals("")
                        || categoryBox.getValue().equals("")
                        || statusBox.getValue().equals("")
                        || readyFrom.getText().equals("")
                        || readyTill.getText().equals("")
                        || fuelTank.getText().equals("")
                ) {
                    errorMessage.setText("Bitte jedes Feld ausfüllen!");
                    errorMessage.setVisible(true);
                } else {
                    errorMessage.setVisible(false);
                    Motorcycle motorcycle = new Motorcycle();

                    String ccmString = ccm.getText();
                    String mileageString = mileage.getText();
                    String fuelString = fuelTank.getText();
                    int ccmConverted = Integer.parseInt(ccmString);
                    int mileageConverted = Integer.parseInt(mileageString);
                    int fuelConverted = Integer.parseInt(fuelString);


                    motorcycle.setVehicleBrand(vehicleBrand.getText());
                    motorcycle.setModel(model.getText());
                    motorcycle.setCcm(ccmConverted);
                    motorcycle.setFuelType(String.valueOf(fuelTypeBox.getValue()));
                    motorcycle.setColor(color.getText());
                    motorcycle.setMileage(mileageConverted);
                    motorcycle.setCategory(String.valueOf(categoryBox.getValue()));
                    motorcycle.setLicensePlate(licensePlate.getText());
                    motorcycle.setAvailableFrom(readyFrom.getText());
                    motorcycle.setAvailableTill(readyTill.getText());
                    motorcycle.setStatus(String.valueOf(statusBox.getValue()));
                    motorcycle.setFuelTank(fuelConverted);

                    list.addVehicles(motorcycle);
                }
            }
        });
        //clears input fields
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vehicleBrand.setText("");
                model.setText("");
                ccm.setText("");
                fuelTypeBox.setValue("");
                color.setText("");
                mileage.setText("");
                licensePlate.setText("");
                categoryBox.setValue("");
                readyFrom.setText("");
                readyTill.setText("");
                statusBox.setValue("");
                fuelTank.setText("");
            }
        });


    }
}
