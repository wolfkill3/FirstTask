package address;

import java.util.*;

public class Person implements Comparable<Person>{
    private final String firstName;
    private final String secondName;
    private final Date dateOfBirth;
    private final Address address;

    public Person(final String firstName, final String secondName, final Date dateOfBirth, final Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public int compareTo(final Person person) {
        return dateOfBirth.compareTo(person.getDateOfBirth());
    }

    @Override
    public String toString() {
        return "Person{" +
               "firstName='" + firstName + '\'' +
               ", secondName='" + secondName + '\'' +
               ", dateOfBirth=" + dateOfBirth +
               ", address=" + address +
               '}';
    }
}
