package application;

import application.service.CustomerList;
import application.service.PersistenceService;
import application.service.RentalList;
import application.service.VehicleList;
import javafx.stage.Stage;

public class GlobalAccessVariables {
    public static VehicleList vehicleList;
    public static RentalList rentalList;
    public static PersistenceService persistenceService;
    public static CustomerList customerList;
    public static Stage mainStage;
}
