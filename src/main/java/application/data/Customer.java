package application.data;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String addStreet;
    private int addNumber;
    private int addPostalCode;
    private String phoneNumber;
    private String email;
    private String dateOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public void setAddStreet(String addStreet) {
        this.addStreet = addStreet;
    }

    public int getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(int addNumber) {
        this.addNumber = addNumber;
    }

    public int getAddPostalCode() {
        return addPostalCode;
    }

    public void setAddPostalCode(int addPostalCode) {
        this.addPostalCode = addPostalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return firstName + " " +lastName;
    }
}
