import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InstockTest {

    private ProductStock stock;
    public static final Product product1 = new Product("water", 1.20, 2);
    public static final Product product2 = new Product("bread", 0.90, 3);
    public static final Product product3 = new Product("Cola", 2.50, 5);
    public static final int quantity = 12;

    @Before
    public void setup() {
        stock = new Instock();
    }

    @Test
    public void testContainsAndAdd() {

        Assert.assertFalse(this.stock.contains(product1));
        this.stock.add(product1);
        Assert.assertTrue(this.stock.contains(product1));
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, stock.getCount());
        fillStock(stock);
        Assert.assertEquals(3, stock.getCount());
    }

    @Test
    public void testFind() {
        fillStock(this.stock);

        Assert.assertEquals(product2.getLabel(), stock.find(1).getLabel());
        Assert.assertEquals(product2.getQuantity(), stock.find(1).getQuantity());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindIndexOutOfBounds() throws IndexOutOfBoundsException {
        fillStock(this.stock);
        this.stock.find(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindIndexNegativeNumberThrowsException() {
        this.stock.find(-1);
    }

    @Test
    public void testChangeQuantity(){
        fillStock(stock);
        stock.changeQuantity("water", quantity);
        Assert.assertEquals(stock.find(0).getQuantity(), quantity);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testChangeQuantityInvalidNameThrowsException(){
        stock.changeQuantity("awsd", quantity);
    }
    @Test
    public void testFindByLabelValidLabel(){
        fillStock(stock);
        Assert.assertEquals(stock.findByLabel("bread"), product2);

    }
    @Test (expected = IllegalArgumentException.class)
    public void testFindByLabelInvalidLabel(){
        stock.findByLabel("Ashwaghanda");

    }
    @Test
    public void testFindFirstByAlphabeticalOrder() {
    fillStock(stock);

    }

    private void fillStock(ProductStock stock) {
        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
    }
}