package address;

import java.util.*;
import java.util.stream.Collectors;

public class PersonFinder {
    public static Person findBySecondName(final String secondName, final List<Person> people) {
        var optionalPerson = people.stream()
                                   .filter(person -> person.getSecondName().equals(secondName))
                                   .findFirst();

        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new RuntimeException("Человека с такой фамилией нет в списке!");
        }
    }

    public static Person findByAddressAttribute(final String street, final List<Person> people) {
        var optionalPerson = people.stream()
                                   .filter(person -> person.getAddress().getStreet().equals(street))
                                   .findFirst();

        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new RuntimeException("Человека, проживающего на такой улице, нет в списке!");
        }
    }

    public static Person findByAddressAttribute(final int homeNumber, final List<Person> people) {
        var optionalPerson = people.stream()
                                   .filter(person -> person.getAddress().getHomeNumber() == homeNumber)
                                   .findFirst();

        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            throw new RuntimeException("Человека, проживающего в доме с номером " + homeNumber + ", нет в списке!");
        }
    }

    public static List<Person> findPersonsWithDateOfBirthRange(final Date dateFrom, Date dateTo, final List<Person> people) {
        return people.stream()
                     .filter(person -> person.getDateOfBirth().after(dateFrom)
                                       && person.getDateOfBirth().before(dateTo))
                     .collect(Collectors.toList());
    }

    public static Person getOldestPerson(final List<Person> people) {
        List<Person> personList = new ArrayList<>(people);
        Collections.sort(personList);
        return personList.get(0);
    }

    public static List<Person> getPeopleByStreet(String street, List<Person> people) {
        return people.stream()
                     .filter(person -> person.getAddress().getStreet().equals(street))
                     .collect(Collectors.toList());
    }
}
