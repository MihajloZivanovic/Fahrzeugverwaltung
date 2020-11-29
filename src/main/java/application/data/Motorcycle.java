package application.data;

public class Motorcycle extends Vehicle {
    private int fuelTank;

    public Motorcycle() {
        super.setType("Motorrad");
    }

    public int getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(int fuelTank) {
        this.fuelTank = fuelTank;
    }
}
