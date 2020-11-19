package application.main;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.jfoenix.controls.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class registerVehicle implements Initializable {

    ObjectMapper objectMapper = new ObjectMapper();

    @FXML
    TextField carBrand;
    @FXML
    TextField model;
    @FXML
    TextField ccm;
    @FXML
    TextField fuelType;
    @FXML
    TextField category;
    @FXML
    TextField licensePlate;
    @FXML
    TextField mileage;
    @FXML
    TextField color;
    @FXML
    JFXButton save;
    @FXML
    JFXButton clear;
    @FXML
    Label errorMessage;


    public void initialize(URL location, ResourceBundle resources) {
        save.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(carBrand.getText().equals("") || model.getText().equals("") || ccm.getText().equals("")|| fuelType.getText().equals("") || category.getText().equals("") || licensePlate.getText().equals("") || mileage.getText().equals("") || color.getText().equals(""))
                {
                    errorMessage.setText("Bitte jedes Feld ausfüllen!");
                    errorMessage.setVisible(true);
                }else {
                    errorMessage.setVisible(false);

                }
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                carBrand.setText("");
                model.setText("");
                ccm.setText("");
                fuelType.setText("");
                category.setText("");
                licensePlate.setText("");
                mileage.setText("");
                color.setText("");
            }
        });


    }
}
