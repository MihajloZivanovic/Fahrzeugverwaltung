package application.main;

import application.classes.Vehicle;
import application.classes.VehicleList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

import javafx.scene.control.*;
import com.jfoenix.controls.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class RegisterVehicle implements Initializable {

    ObjectMapper objectMapper = new ObjectMapper();
    String pathToFile = "vehicleList.json";
    VehicleList list = new VehicleList();

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
    DatePicker readyFrom;
    @FXML
    DatePicker readyTill;
    @FXML
    ChoiceBox statusBox;
    @FXML
    JFXButton save;
    @FXML
    JFXButton clear;
    @FXML
    Label errorMessage;

    public void initialize(URL location, ResourceBundle resources) {

        fuelTypeBox.setItems(fuelTypeList);
        categoryBox.setItems(categoryList);
        statusBox.setItems(statusList);

        //String stringReadyFrom = readyFrom.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //String stringReadyTill = readyTill.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        //saves input to json, hopefully...  it jammers when an input field wasn't filled
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(vehicleBrand.getText().equals("")
                        || model.getText().equals("")
                        || ccm.getText().equals("")
                        || fuelTypeBox.getValue().equals("")
                        || color.getText().equals("")
                        || mileage.getText().equals("")
                        || licensePlate.getText().equals("")
                        || categoryBox.getValue().equals("")
                        || statusBox.getValue().equals("")
                )
                {
                    errorMessage.setText("Bitte jedes Feld ausfüllen!");
                    errorMessage.setVisible(true);
                }else {
                    errorMessage.setVisible(false);

                    Map<>objectMapper.readValue(Paths.get(pathToFile).toFile(), List.class);

                    Vehicle vehicle = new Vehicle();


                    String ccmString = ccm.getText();
                    String mileageString = mileage.getText();

                    int ccmConverted = Integer.parseInt(ccmString);
                    int mileageConverted = Integer.parseInt(mileageString);
                    vehicle.setVehicleBrand(vehicleBrand.getText());
                    vehicle.setModel(model.getText());
                    vehicle.setCcm(ccmConverted);
                    vehicle.setFuelType(String.valueOf(fuelTypeBox.getValue()));
                    vehicle.setColor(color.getText());
                    vehicle.setMileage(mileageConverted);
                    vehicle.setCategory(String.valueOf(categoryBox.getValue()));
                    vehicle.setLicensePlate(licensePlate.getText());
                    //vehicle.setAvailableFrom(stringReadyFrom);
                    //vehicle.setAvailableTill(stringReadyTill);
                    vehicle.setStatus(String.valueOf(statusBox.getValue()));

                    list.addVehicles(vehicle);

                    try {
                        JsonGenerator file = objectMapper.getFactory().createGenerator(new FileOutputStream(pathToFile));
                        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, list);
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        //clears input fields
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vehicleBrand.setText("");
                model.setText("");
                ccm.setText("");
                licensePlate.setText("");
                mileage.setText("");
                color.setText("");
            }
        });


    }
}
