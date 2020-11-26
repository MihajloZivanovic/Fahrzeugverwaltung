package application.classes;

import java.util.ArrayList;
import java.util.List;

public class VehicleList {
    private static List<Vehicle> vehicleList = new ArrayList<>();

    public static List<Vehicle> getVehicles() {
        return vehicleList;
    }

    public static void setVehicles(List<Vehicle> vehicles) {
        VehicleList.vehicleList = vehicles;
    }

    public void addVehicles(Vehicle vehicle){
        vehicleList.add(vehicle);
    }
}
