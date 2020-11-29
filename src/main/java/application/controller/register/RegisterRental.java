package application.controller.register;

import application.GlobalAccessVariables;
import application.data.*;
import application.service.TableViewConstructor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.objects.Global;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterRental implements Initializable {

    ObservableList<String> statusList = FXCollections.observableArrayList("Offen", "Ausbezahlt","FertigDing");

    @FXML
    JFXButton vehicleRegisterButton, customerRegisterButton, vehicleListButton, rentalButton, rentalListButton, customerListButton;
    @FXML
    JFXButton homeButton;
    @FXML
    JFXTreeTableView vehicleRentalList, customerRentalList;
    @FXML
    TextField price, from, until;
    @FXML
    ChoiceBox statusRental;

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

    public void registerRental(){
        Rental tmpRental = new Rental();
        Object selectedVehicle = vehicleRentalList.getTreeItem(vehicleRentalList.getSelectionModel().getFocusedIndex()).getValue();
        if(selectedVehicle instanceof Car) tmpRental.setVehicle((Car) selectedVehicle);
        if(selectedVehicle instanceof Motorcycle) tmpRental.setVehicle((Motorcycle) selectedVehicle);
        if(selectedVehicle instanceof Transporter) tmpRental.setVehicle((Transporter) selectedVehicle);

        Customer selectedCustomer = (Customer) customerRentalList.getTreeItem(customerRentalList.getSelectionModel().getFocusedIndex()).getValue();
        tmpRental.setCustomer(selectedCustomer);

        tmpRental.setPrice(Float.parseFloat(price.getText()));
        tmpRental.setStatusOfRent(String.valueOf(statusRental.getValue()));
        tmpRental.setFrom(from.getText());
        tmpRental.setUntil(until.getText());

        GlobalAccessVariables.rentalList.addRental(tmpRental);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        from.setPromptText("tt-mm-jjjj");
        until.setPromptText("tt-mm-jjjj");

        statusRental.setItems(statusList);

        TableViewConstructor.initializeCustomerTableView(customerRentalList, true);
        TableViewConstructor.populateTableView(GlobalAccessVariables.customerList.getCustomerList(), customerRentalList);

        TableViewConstructor.initializeVehicleTableView(vehicleRentalList, true);
        TableViewConstructor.populateTableView(GlobalAccessVariables.vehicleList.getVehicles(), vehicleRentalList);

    }
}
