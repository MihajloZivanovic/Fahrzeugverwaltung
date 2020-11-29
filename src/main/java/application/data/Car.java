package application.data;

public class Car extends Vehicle {
    private int trunkSpace;
    private String make;
    private String satnav;

    public Car() {
        super.setType("Auto");
    }

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

    public String getSatnav() {
        return satnav;
    }

    public void setSatnav(String satnav) {
        this.satnav = satnav;
    }
}
