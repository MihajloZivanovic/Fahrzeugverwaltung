package application.controller;

import application.GlobalAccessVariables;
import application.service.CustomerList;
import application.service.PersistenceService;
import application.service.RentalList;
import application.service.VehicleList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void init() throws Exception {
        GlobalAccessVariables.vehicleList = new VehicleList();
        GlobalAccessVariables.rentalList = new RentalList();
        GlobalAccessVariables.customerList = new CustomerList();
        GlobalAccessVariables.persistenceService = new PersistenceService();
        GlobalAccessVariables.persistenceService.readFile();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/application/controller/primaryView.fxml"));
        GlobalAccessVariables.mainStage = primaryStage;
        primaryStage.setTitle("Fahrzeugverwalutng");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            GlobalAccessVariables.persistenceService.writeFile();
            Platform.exit();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}