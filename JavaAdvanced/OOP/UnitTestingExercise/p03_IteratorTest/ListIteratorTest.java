package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator("Ivan","Georgi","Asen");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingListIteratorWithNullShouldThrow() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNext() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test
    public void testPrint() {
        String printed = listIterator.print();

        assertEquals("Ivan", printed);

    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWithEmptyListIterator() throws OperationNotSupportedException {
        ListIterator emptyListiterator = new ListIterator();
        emptyListiterator.print();
    }
}