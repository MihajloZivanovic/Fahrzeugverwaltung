package application.service;

import application.GlobalAccessVariables;
import application.data.Customer;
import application.data.DataWrapper;
import application.data.Rental;
import application.data.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenceService {

    ObjectMapper objectMapper;
    File file;

    public PersistenceService() {
        file = new File("data.json");
        objectMapper = new ObjectMapper();

        PolymorphicTypeValidator validator = BasicPolymorphicTypeValidator.builder().allowIfSubType(Vehicle.class).build();

        objectMapper.activateDefaultTyping(validator);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
    }

    public void readFile() {
        if (file.exists()) {
            try {
                DataWrapper dataWrapper = objectMapper.readValue(file, DataWrapper.class);
                GlobalAccessVariables.vehicleList.setVehicles(dataWrapper.vehicleList);
                GlobalAccessVariables.customerList.setCustomerList(dataWrapper.customerList);
                for (Rental rental : dataWrapper.rentalList) {
                    for (Vehicle vehicle : GlobalAccessVariables.vehicleList.getVehicles()) {
                        if (rental.getVehicleId() == vehicle.getId()) {
                            rental.setVehicle(vehicle);
                        }
                    }
                    for (Customer customer : GlobalAccessVariables.customerList.getCustomerList()) {
                        if (rental.getCustomerId() == customer.getId()) {
                            rental.setCustomer(customer);
                        }
                    }
                    rental.setVehicleId(-1);
                    rental.setCustomerId(-1);
                }
                for (Vehicle vehicle : GlobalAccessVariables.vehicleList.vehicleList) {
                    vehicle.setId(-1);
                }
                for (Customer customer : GlobalAccessVariables.customerList.customerList) {
                    customer.setId(-1);
                }
                GlobalAccessVariables.rentalList.setRentalList(dataWrapper.rentalList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFile() {
        List<Vehicle> vehicleList = GlobalAccessVariables.vehicleList.vehicleList;
        List<Customer> customerList = GlobalAccessVariables.customerList.customerList;
        List<Rental> rentalList = GlobalAccessVariables.rentalList.rentalList;
        for (int i = 0; i < vehicleList.size(); i++) {
            vehicleList.get(i).setId(i);
        }
        for (int i = 0; i < customerList.size(); i++) {
            customerList.get(i).setId(i);
        }
        for (Rental rental : rentalList) {
            rental.setVehicleId(rental.getVehicle().getId());
            rental.setVehicle(null);
            rental.setCustomerId(rental.getCustomer().getId());
            rental.setCustomer(null);
        }

        DataWrapper dataWrapper = new DataWrapper();
        dataWrapper.vehicleList = new ArrayList<>(vehicleList);
        dataWrapper.rentalList = new ArrayList<>(rentalList);
        dataWrapper.customerList = new ArrayList<>(customerList);

        String dataJson = null;
        try {
            dataJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataWrapper);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Parsing to JSON failed!");
        }
        if (dataJson != null) {
            try {
                BufferedWriter dataWriter = new BufferedWriter(new FileWriter(file));
                dataWriter.write(dataJson);
                dataWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Writing to File failed!");
            }
        }
        System.out.println("Saved File");
    }

}
