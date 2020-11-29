package application.controller.display;

import application.GlobalAccessVariables;
import application.data.Vehicle;
import application.service.TableViewConstructor;
import application.service.VehicleList;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DisplayVehicle implements Initializable {

    @FXML
    JFXButton vehicleRegisterButton, customerRegisterButton, vehicleListButton, rentalButton, rentalListButton, customerListButton;
    @FXML
    JFXButton homeButton;
    @FXML
    JFXButton deleteButton;
    @FXML
    JFXTreeTableView vehicleTableView;

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
        } else{
            root = FXMLLoader.load(getClass().getResource("/application/controller/primaryView.fxml"));
        }
        GlobalAccessVariables.mainStage.getScene().setRoot(root);
    }

    public void delete(){
        GlobalAccessVariables.vehicleList.removeVehicle((Vehicle) vehicleTableView.getTreeItem(vehicleTableView.getSelectionModel().getFocusedIndex()).getValue());
        TableViewConstructor.populateTableView(GlobalAccessVariables.vehicleList.getVehicles(),vehicleTableView);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TableViewConstructor.initializeVehicleTableView(vehicleTableView, false);
        TableViewConstructor.populateTableView(GlobalAccessVariables.vehicleList.getVehicles(), vehicleTableView);


    }
}
