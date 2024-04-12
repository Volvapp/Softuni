package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private p01_Database.Database database;
    private static final Integer[] NUMBERS = {12, 3, 45, 6, 7, 19};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new p01_Database.Database(NUMBERS);
    }

    @Test
    public void testConstructorHasCreatedValidObject() {
        Integer[] elements = database.getElements();

        Assert.assertArrayEquals(elements, NUMBERS);

//        Assert.assertEquals(elements.length, NUMBERS.length);
//
//        for (int index = 0; index < elements.length; index++) {
//            Assert.assertEquals(elements[index], NUMBERS[index]);
//        }

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new p01_Database.Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] num = new Integer[0];
        new Database(num);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionWhenNullParam() throws OperationNotSupportedException {
        database.add(null);

    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {

        database.add(67);
        Integer[] elements = database.getElements();

        Assert.assertEquals("Invalid add operation!", elements.length, NUMBERS.length + 1);

        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(67));
    }

    @Test
    public void testRemoveShouldRemoveLastIndexElement() throws OperationNotSupportedException {
        database.remove();
        //7
        Integer[] elements = database.getElements();
        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(7));


        Assert.assertEquals(elements.length, NUMBERS.length - 1);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExceptionWhenEmpty() throws OperationNotSupportedException {
        for (int i = 0; i <= NUMBERS.length; i++) { // throws exception cuz of the <=
            database.remove();
        }
    }
}