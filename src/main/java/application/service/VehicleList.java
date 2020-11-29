package application.service;

import application.data.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleList {
    public List<Vehicle> vehicleList = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return vehicleList;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleList = vehicles;
    }

    public void addVehicles(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        vehicleList.remove(vehicle);
    }
}
