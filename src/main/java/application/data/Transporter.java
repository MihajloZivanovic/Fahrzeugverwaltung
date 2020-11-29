package application.data;

public class Transporter extends Vehicle {
    private int loadWeight;

    public Transporter() {
        super.setType("Transporter");
    }

    public int getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(int loadWeight) {
        this.loadWeight = loadWeight;
    }
}
