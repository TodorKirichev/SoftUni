package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;

    private static final Integer[] NUMBERS = {1, 2, 5, -5, 10};

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }
    @Test
    public void createDatabase() {

        assertArrayEquals(database.getElements(),NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createDatabaseWithLessThanOneElement() throws OperationNotSupportedException {

        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void createDatabaseWithMoreThenSixteenElements() throws OperationNotSupportedException {
        Integer[] bigArray = new Integer[20];

        new Database(bigArray);
    }

    @Test
    public void addingElement() throws OperationNotSupportedException {

        database.add(20);
        int lastElement = database.getElements()[database.getElements().length - 1];

        assertEquals(20, lastElement);
        assertEquals(NUMBERS.length + 1, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNull() throws OperationNotSupportedException {

        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void removingElement() throws OperationNotSupportedException {
       database.remove();

       assertEquals(NUMBERS.length - 1, database.getElements().length);
        for (int i = 0; i < database.getElements().length; i++) {
            assertEquals(NUMBERS[i], database.getElements()[i]);
        }
    }

}