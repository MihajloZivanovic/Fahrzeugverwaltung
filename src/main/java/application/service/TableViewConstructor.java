package application.service;

import application.data.Customer;
import application.data.Rental;
import application.data.Vehicle;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableViewConstructor {
    public static void initializeVehicleTableView(JFXTreeTableView treeTableView, boolean small) {
        JFXTreeTableColumn<Vehicle, String> columnType = new JFXTreeTableColumn<>("Typ");
        JFXTreeTableColumn<Vehicle, String> columnBrand = new JFXTreeTableColumn<>("Marke");
        JFXTreeTableColumn<Vehicle, String> columnModel = new JFXTreeTableColumn<>("Model");
        JFXTreeTableColumn<Vehicle, Integer> columnCcm = new JFXTreeTableColumn<>("ccm");
        JFXTreeTableColumn<Vehicle, String> columnFuelType = new JFXTreeTableColumn<>("Fuel Type");
        JFXTreeTableColumn<Vehicle, String> columnColor = new JFXTreeTableColumn<>("Color");
        JFXTreeTableColumn<Vehicle, Integer> columnMileage = new JFXTreeTableColumn<>("KM-Stand");
        JFXTreeTableColumn<Vehicle, String> columnLicensePlate = new JFXTreeTableColumn<>("Kennzeichen");
        columnType.setCellValueFactory(new TreeItemPropertyValueFactory<>("type"));
        columnBrand.setCellValueFactory(new TreeItemPropertyValueFactory<>("vehicleBrand"));
        columnModel.setCellValueFactory(new TreeItemPropertyValueFactory<>("model"));
        columnCcm.setCellValueFactory(new TreeItemPropertyValueFactory<>("ccm"));
        columnFuelType.setCellValueFactory(new TreeItemPropertyValueFactory<>("fuelType"));
        columnColor.setCellValueFactory(new TreeItemPropertyValueFactory<>("color"));
        columnMileage.setCellValueFactory(new TreeItemPropertyValueFactory<>("mileage"));
        columnLicensePlate.setCellValueFactory(new TreeItemPropertyValueFactory<>("licensePlate"));
        List<JFXTreeTableColumn> columns = new ArrayList<>();
        if (small) {
            Collections.addAll(columns, columnType, columnBrand, columnLicensePlate);
        } else {
            Collections.addAll(columns, columnType, columnBrand, columnModel, columnCcm, columnFuelType, columnColor, columnMileage, columnLicensePlate);
        }
        treeTableView.getColumns().addAll(columns);
    }

    public static void initializeRentalTableView(JFXTreeTableView treeTableView, boolean small) {
        JFXTreeTableColumn<Rental, Float> columnPrice = new JFXTreeTableColumn<>("Preis");
        JFXTreeTableColumn<Rental, String> columnStatus = new JFXTreeTableColumn<>("Status");
        JFXTreeTableColumn<Rental, String> columnFrom = new JFXTreeTableColumn<>("Von");
        JFXTreeTableColumn<Rental, String> columnUntil = new JFXTreeTableColumn<>("Bis");
        JFXTreeTableColumn<Rental, String> columnCustomer = new JFXTreeTableColumn<>("Kunde");
        columnPrice.setCellValueFactory(new TreeItemPropertyValueFactory<>("price"));
        columnStatus.setCellValueFactory(new TreeItemPropertyValueFactory<>("statusOfRent"));
        columnFrom.setCellValueFactory(new TreeItemPropertyValueFactory<>("from"));
        columnUntil.setCellValueFactory(new TreeItemPropertyValueFactory<>("until"));
        columnCustomer.setCellValueFactory(new TreeItemPropertyValueFactory<>("customer"));
        List<JFXTreeTableColumn> columns = new ArrayList<>();
        if (small) {
            Collections.addAll(columns, columnPrice, columnStatus);
        } else {
            Collections.addAll(columns, columnPrice, columnStatus, columnFrom, columnUntil, columnCustomer);
        }

        treeTableView.getColumns().addAll(columns);
    }

    public static void initializeCustomerTableView(JFXTreeTableView treeTableView, boolean small) {
        JFXTreeTableColumn<Customer, String> columnName = new JFXTreeTableColumn<>("Name");
        JFXTreeTableColumn<Customer, String> columnLastName = new JFXTreeTableColumn<>("Nachname");
        JFXTreeTableColumn<Customer, String> columnCity = new JFXTreeTableColumn<>("Ort");
        JFXTreeTableColumn<Customer, Integer> columnStreet = new JFXTreeTableColumn<>("Strasse");
        JFXTreeTableColumn<Customer, String> columnNumber = new JFXTreeTableColumn<>("Nr");
        JFXTreeTableColumn<Customer, String> columnPostal = new JFXTreeTableColumn<>("PLZ");
        JFXTreeTableColumn<Customer, Integer> columnEmail = new JFXTreeTableColumn<>("Email");
        JFXTreeTableColumn<Customer, String> columnDateOfBirth = new JFXTreeTableColumn<>("Geburtsdatum");
        columnName.setCellValueFactory(new TreeItemPropertyValueFactory<>("firstName"));
        columnLastName.setCellValueFactory(new TreeItemPropertyValueFactory<>("lastName"));
        columnCity.setCellValueFactory(new TreeItemPropertyValueFactory<>("city"));
        columnStreet.setCellValueFactory(new TreeItemPropertyValueFactory<>("addStreet"));
        columnNumber.setCellValueFactory(new TreeItemPropertyValueFactory<>("addNumber"));
        columnPostal.setCellValueFactory(new TreeItemPropertyValueFactory<>("addPostalCode"));
        columnEmail.setCellValueFactory(new TreeItemPropertyValueFactory<>("email"));
        columnDateOfBirth.setCellValueFactory(new TreeItemPropertyValueFactory<>("dateOfBirth"));
        List<JFXTreeTableColumn> columns = new ArrayList<>();
        if (small) {
            Collections.addAll(columns, columnName, columnLastName);
        } else {
            Collections.addAll(columns, columnName, columnLastName, columnCity, columnStreet, columnNumber, columnPostal, columnEmail, columnDateOfBirth);
        }
        treeTableView.getColumns().addAll(columns);
    }

    public static void populateTableView(List objectList, JFXTreeTableView treeTableView) {
        TreeItem objects = new TreeItem<>();
        objectList.forEach(object -> {
            objects.getChildren().add(new TreeItem<>(object));
        });
        treeTableView.setRoot(objects);
        treeTableView.setShowRoot(false);
    }
}
