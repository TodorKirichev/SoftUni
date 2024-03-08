package TestDrivenDevelopment;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private Instock products;

    private Iterable<Product> foundProducts;

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

    @Test
    public void changeQuantitySuccess() {
        products.changeQuantity("water", 4);

        assertEquals(4, products.find(0).getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowIfNoSuchProduct() {
        products.changeQuantity("tomato", 8);
    }

    @Test
    public void findByLabelSuccess() {
        Product product = products.findByLabel("water");
        Product expectedProduct = products.find(0);

        assertEquals(expectedProduct, product);
    }

    @Test(expected = IllegalArgumentException .class)
    public void findByLabelShouldThrowIfNoSuchProduct() {
        products.findByLabel("milk");
    }

    @Test
    public void findFirstByAlphabeticalOrderSuccess() {
        List<Product> expectedProducts = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            expectedProducts.add(products.find(i));
        }

        expectedProducts = expectedProducts
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());

        foundProducts = products.findFirstByAlphabeticalOrder(3);

        List<Product> returnedProducts = new ArrayList<>();

        foundProducts.forEach(returnedProducts::add);

        assertEquals(expectedProducts, returnedProducts);
    }

    @Test
    public void findFirstByAlphabeticalOrderReturnEmptyCollectionIfArgumentIsOutOfRange() {
        foundProducts = products.findFirstByAlphabeticalOrder(10);

        int counter = getCounter(foundProducts);

        assertEquals(0, counter);
    }

    @Test
    public void findAllInPriceRangeSuccess() {
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(products.find(2));
        expectedProducts.add(products.find(1));

        foundProducts = products.findAllInRange(1.20, 4.30);

        List<Product> returnedProducts = new ArrayList<>();
        foundProducts.forEach(returnedProducts::add);

        assertEquals(expectedProducts, returnedProducts);
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyCollectionIfNoSuchProduct() {
        foundProducts = products.findAllInRange(10, 20);

        List<Product> returnedProducts = new ArrayList<>();
        foundProducts.forEach(returnedProducts::add);

        assertTrue(returnedProducts.isEmpty());
    }

    @Test
    public void findAllByPriceSuccess() {
        products.add(new Product("eggs", 4.30, 12));
        foundProducts = products.findAllByPrice(4.30);

        int counter = getCounter(foundProducts);
        assertEquals(2, counter);
    }

    @Test
    public void findAllByPriceShouldReturnEmptyCollectionIfNoSuchPrice() {
        foundProducts = products.findAllByPrice(3.70);

        int counter = getCounter(foundProducts);

        assertEquals(0,counter);
    }

    @Test
    public void findFirstMostExpensiveProductsSuccess() {
        foundProducts = products.findFirstMostExpensiveProducts(2);

        int counter = getCounter(foundProducts);

        assertEquals(2, counter);
    }

    @Test(expected = IllegalArgumentException .class)
    public void findFirstMostExpensiveProductsShouldThrowIfLessThanCounts() {
        foundProducts = products.findFirstMostExpensiveProducts(6);
    }

    @Test
    public void findAllByQuantitySuccess() {
        products.add(new Product("onion", 2.10, 2));
        foundProducts = products.findAllByQuantity(2);

        int counter = getCounter(foundProducts);

        assertEquals(2, counter);
    }

    @Test
    public void findAllByQuantityShouldReturnEmptyCollectionIfNoSuchProducts() {
        foundProducts = products.findAllByQuantity(7);

        int counter = getCounter(foundProducts);

        assertEquals(0, counter);
    }

    @Test
    public void getIterableShouldReturnCorrect() {
        Iterator<Product> iterator = products.iterator();

        List<Product> returnedProducts = new ArrayList<>();

        while (iterator.hasNext()) {
            returnedProducts.add(iterator.next());
        }

        for (int i = 0; i < returnedProducts.size(); i++) {
            assertEquals(products.find(i), returnedProducts.get(i));
        }
    }

    private int getCounter(Iterable<Product> foundProducts) {
        int counter = 0;
        for (Product foundProduct : this.foundProducts) {
            counter++;
        }
        return counter;
    }
}