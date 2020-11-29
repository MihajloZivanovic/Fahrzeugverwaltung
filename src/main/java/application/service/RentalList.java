package application.service;

import application.data.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalList {
    public List<Rental> rentalList = new ArrayList<>();

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public void removeRental(Rental rental) {
        rentalList.remove(rental);
    }

}
