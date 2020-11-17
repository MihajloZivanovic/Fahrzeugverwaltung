package application.classes;

public class Car extends Vehicle {
    private int trunkSpace;
    private String make;
    private boolean satnav;

    public int getTrunkSpace() {
        return trunkSpace;
    }

    public void setTrunkSpace(int trunkSpace) {
        this.trunkSpace = trunkSpace;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public boolean isSatnav() {
        return satnav;
    }

    public void setSatnav(boolean satnav) {
        this.satnav = satnav;
    }
}
