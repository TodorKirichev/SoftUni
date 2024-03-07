package TestDrivenDevelopment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InstockTest {

    private Instock products;

    private Product newProduct;

    @Before
    public void setup() {
        products = new Instock();
        products.add(new Product("water", 1.20, 3));
        products.add(new Product("bread", 1.60, 2));
        products.add(new Product("cheese", 4.30, 1));
        newProduct = new Product("potato", 2.20, 10);
    }

    @Test
    public void addingAndContainsProduct() {

        assertFalse(products.contains(newProduct));

        products.add(newProduct);

        assertTrue(products.contains(newProduct));
    }

    @Test
    public void countReturnCorrectNumberOfProducts() {
        assertEquals(3, products.getCount());

        products.add(newProduct);

        assertEquals(4, products.getCount());
    }

    @Test
    public void findReturnCorrect() {
        products.add(newProduct);

        Product found = products.find(3);

        assertEquals(newProduct, found);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findThrowWithNegativeIndex() {
        products.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findThrowWithBiggerIndex() {
        products.find(products.getCount());
    }

}