package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    Database database;

    private static final Person[] PEOPLE = {
            new Person(20, "Ivan"),
            new Person(30, "Georgi"),
            new Person(40, "Asen")};

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void createDatabase() {

        assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createDatabaseWithLessThanOneElement() throws OperationNotSupportedException {

        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createDatabaseWithMoreThenSixteenElements() throws OperationNotSupportedException {
        Person[] bigArray = new Person[20];

        new Database(bigArray);
    }

    @Test
    public void addingPerson() throws OperationNotSupportedException {
        Person person = new Person(50, "Todor");

        database.add(person);
        Person lastPerson = database.getElements()[database.getElements().length - 1];

        assertEquals(person, lastPerson);
        assertEquals(PEOPLE.length + 1, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNull() throws OperationNotSupportedException {

        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void removingElement() throws OperationNotSupportedException {
        database.remove();

        assertEquals(PEOPLE.length - 1, database.getElements().length);
        for (int i = 0; i < database.getElements().length; i++) {
            assertEquals(PEOPLE[i], database.getElements()[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameWithNull() throws OperationNotSupportedException {

        database.findByUsername(null);
    }

    @Test
    public void findByUsernameWithExistingUsername() throws OperationNotSupportedException {

        Person person = database.findByUsername("Georgi");
        assertEquals("Georgi",person.getUsername());
        assertEquals(30, person.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameWithNonExistingUsername() throws OperationNotSupportedException {

       database.findByUsername("Pesho");

    }

    @Test
    public void findByIdWithExistingId() throws OperationNotSupportedException {

        Person person = database.findById(20);
        assertEquals(20, person.getId());
        assertEquals("Ivan", person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdWithNonExistingId() throws OperationNotSupportedException {

        database.findById(60);
    }

}