package session06;

public class Address {

    private String street;
    private String number;
    private String town;

    public Address(String street, String number, String town) {
        this.street = street;
        this.number = number;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getTown() {
        return town;
    }

    public String toString() {
        return street + " " + number + ", " + town;
    }
}
