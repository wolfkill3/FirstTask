package address;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonUtilsTest {
    private static final List<Person> PEOPLE = new LinkedList<>();
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    static {
        try {
            Address address = new Address("Владимира Невского", 22);
            Person person = new Person("Андрей", "Васильев", FORMAT.parse("29/11/2000"), address);
            PEOPLE.add(person);

            address = new Address("Владимира Невского", 22);
            person = new Person("Вадим", "Медведев", FORMAT.parse("15/02/2005"), address);
            PEOPLE.add(person);

            address = new Address("Проспект Вернадского", 57);
            person = new Person("Алексей", "Андреев", FORMAT.parse("12/04/2013"), address);
            PEOPLE.add(person);

            address = new Address("Проспект Большевиков", 82);
            person = new Person("Владислав", "Песков", FORMAT.parse("22/05/1999"), address);
            PEOPLE.add(person);

            address = new Address("Удельная", 33);
            person = new Person("Анастасия", "Михайлова", FORMAT.parse("26/09/1995"), address);
            PEOPLE.add(person);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findBySecondNameTest() {
        Assertions.assertEquals("Медведев",
            PersonUtils.findBySecondName("Медведев", PEOPLE).getSecondName());
    }

    @Test
    public void findByAddressAttributeTest() {
        Assertions.assertEquals(PEOPLE.get(0),
            PersonUtils.findByAddressAttribute("Владимира Невского", PEOPLE));

        Assertions.assertEquals(PEOPLE.get(0),
            PersonUtils.findByAddressAttribute(22, PEOPLE));
    }

    @Test
    public void findPersonsWithDateOfBirthRangeTest() throws ParseException {
        Date dateFrom = FORMAT.parse("01/01/2000");
        Date dateTo = FORMAT.parse("01/01/2006");
        List<Person> people = PersonUtils.findPersonsWithDateOfBirthRange(dateFrom, dateTo, PEOPLE);
        people.forEach(System.out::println);
        Assertions.assertEquals(2, people.size());
    }

    @Test
    public void getOldestPersonTest() {
        Assertions.assertEquals(PEOPLE.get(4), PersonUtils.getOldestPerson(PEOPLE));
    }

    @Test
    public void getPeopleByStreetTest() {
        Assertions.assertEquals(2, PersonUtils.getPeopleByStreet("Владимира Невского", PEOPLE).size());
    }
}