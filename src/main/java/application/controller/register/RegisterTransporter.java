package application.controller.register;

import application.GlobalAccessVariables;
import application.data.Transporter;
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

public class RegisterTransporter implements Initializable {

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
            root = FXMLLoader.load(getClass().getResource("/application/controller/register/displayRental.fxml"));
        } else if (event.getSource() == customerListButton) {
            root = FXMLLoader.load(getClass().getResource("/application/controller/register/displayCustomer.fxml"));
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
    TextField loadWeight;
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
                        || loadWeight.getText().equals("")
                ) {
                    errorMessage.setText("Bitte jedes Feld ausfüllen!");
                    errorMessage.setVisible(true);
                } else {
                    errorMessage.setVisible(false);
                    Transporter transporter = new Transporter();

                    String ccmString = ccm.getText();
                    String mileageString = mileage.getText();
                    String loadString = loadWeight.getText();
                    int ccmConverted = Integer.parseInt(ccmString);
                    int mileageConverted = Integer.parseInt(mileageString);
                    int loadConverted = Integer.parseInt(loadString);

                    transporter.setType("Transporter");
                    transporter.setVehicleBrand(vehicleBrand.getText());
                    transporter.setModel(model.getText());
                    transporter.setCcm(ccmConverted);
                    transporter.setFuelType(String.valueOf(fuelTypeBox.getValue()));
                    transporter.setColor(color.getText());
                    transporter.setMileage(mileageConverted);
                    transporter.setCategory(String.valueOf(categoryBox.getValue()));
                    transporter.setLicensePlate(licensePlate.getText());
                    transporter.setAvailableFrom(readyFrom.getText());
                    transporter.setAvailableTill(readyTill.getText());
                    transporter.setStatus(String.valueOf(statusBox.getValue()));
                    transporter.setLoadWeight(loadConverted);


                    list.addVehicles(transporter);
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
                loadWeight.setText("");
            }
        });


    }
}
