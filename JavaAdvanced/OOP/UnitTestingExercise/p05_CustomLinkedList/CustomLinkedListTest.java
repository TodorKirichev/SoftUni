package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<String> customLinkedList;

    @Before
    public void setup() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void addSuccess() {
        customLinkedList.add("Ivan");

        assertEquals("Ivan", customLinkedList.get(0));
    }

    @Test
    public void getWithValidIndex() {
        customLinkedList.add("Ivan");
        customLinkedList.add("Georgi");

        String name = customLinkedList.get(1);

        assertEquals("Georgi", name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWithNegativeIndexShouldThrow() {

      customLinkedList.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWithBiggerIndexShouldThrow() {

        customLinkedList.get(100);
    }

    @Test
    public void setSuccess() {
        customLinkedList.add("Ivan");
        customLinkedList.add("Asen");
        customLinkedList.add("Georgi");

        String name = "Georgi";
        customLinkedList.set(0, name);

        assertEquals(name,customLinkedList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setWithNegativeIndexShouldThrow() {
        customLinkedList.set(-1, "Georgi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setWithBiggerIndexShouldThrow() {
        customLinkedList.set(100, "Georgi");
    }

    @Test
    public void removeAtSuccess() {
        customLinkedList.add("Ivan");

        String removed = customLinkedList.removeAt(0);

        assertEquals("Ivan", removed);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtWithNegativeIndexShouldThrow() {
        customLinkedList.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtWithBiggerIndexShouldThrow() {
        customLinkedList.removeAt(100);
    }

    @Test
    public void removeSuccess() {
        customLinkedList.add("Ivan");

        int removed = customLinkedList.remove("Ivan");

        assertEquals(0, removed);
    }

    @Test
    public void removeNonExisting() {
        int removed = customLinkedList.remove("Ivan");

        assertEquals(-1, removed);
    }

    @Test
    public void indexOfSuccess() {
        customLinkedList.add("Ivan");
        customLinkedList.add("Asen");
        customLinkedList.add("Georgi");

        int indexOf = customLinkedList.indexOf("Asen");

        assertEquals(1, indexOf);
    }

    @Test
    public void indexOfNonExistingElement() {
        int indexOf = customLinkedList.indexOf("Asen");

        assertEquals(-1, indexOf);
    }

    @Test
    public void containsWithExistingElement() {
        customLinkedList.add("Ivan");

        assertTrue(customLinkedList.contains("Ivan"));
    }

    @Test
    public void containsWithNonExistingElement() {
        assertFalse(customLinkedList.contains("Pesho"));
    }

}