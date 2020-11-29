package application.controller.display;

import application.GlobalAccessVariables;
import application.data.Customer;
import application.data.Rental;
import application.service.TableViewConstructor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.net.URL;
import java.util.ResourceBundle;

public class DisplayRental implements Initializable {

    @FXML
    JFXButton vehicleRegisterButton, customerRegisterButton, vehicleListButton, rentalButton, rentalListButton, customerListButton;
    @FXML
    JFXButton homeButton;
    @FXML
    JFXTreeTableView rentalTableView;

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

    public void delete(){
        GlobalAccessVariables.rentalList.removeRental((Rental) rentalTableView.getTreeItem(rentalTableView.getSelectionModel().getFocusedIndex()).getValue());
        TableViewConstructor.populateTableView(GlobalAccessVariables.rentalList.getRentalList(),rentalTableView);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableViewConstructor.initializeRentalTableView(rentalTableView, false);
        TableViewConstructor.populateTableView(GlobalAccessVariables.rentalList.getRentalList(), rentalTableView);
    }
}
