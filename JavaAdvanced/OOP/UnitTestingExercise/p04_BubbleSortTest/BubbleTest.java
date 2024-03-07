package p04_BubbleSortTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    private int[] numbers;

    @Before
    public void setup() {
        numbers = new int[] {1, 2, 3, -5, 10, 5};
    }

    @Test
    public void testSort() {
        Bubble.sort(numbers);

        int[] sorted = new int[]{-5, 1, 2, 3, 5, 10};

        assertArrayEquals(sorted, numbers);
    }
}