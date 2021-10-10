package address;

public class Address {
    private final String street;
    private final int homeNumber;

    public Address(final String street, final int homeNumber) {
        this.street = street;
        this.homeNumber = homeNumber;
    }

    public String getStreet() {
        return street;
    }

    public int getHomeNumber() {
        return homeNumber;
    }
}
