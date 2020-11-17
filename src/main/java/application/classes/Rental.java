package application.classes;

public class Rental {
    private Vehicle vehicle;

    private float price;
    private String statusOfRent;
    private Customer customer;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatusOfRent() {
        return statusOfRent;
    }

    public void setStatusOfRent(String statusOfRent) {
        this.statusOfRent = statusOfRent;
    }
}
