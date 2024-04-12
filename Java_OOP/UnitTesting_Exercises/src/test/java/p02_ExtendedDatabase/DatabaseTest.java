package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    public p02_ExtendedDatabase.Database database;
    private static final Person[] PEOPLE = {new Person(1, "Boris"), new Person(2, "Pesho"), new Person(3, "Ivan")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new p02_ExtendedDatabase.Database(PEOPLE);
    }

    @Test
    public void testConstructorHasCreatedValidObject() {
        Person[] elements = database.getElements();

        Assert.assertArrayEquals(elements, PEOPLE);

//        Assert.assertEquals(elements.length, PEOPLE.length);
//
//        for (int index = 0; index < elements.length; index++) {
//            Assert.assertEquals(elements[index], PEOPLE[index]);
//        }

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new p02_ExtendedDatabase.Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionWhenNullParam() throws OperationNotSupportedException {
        database.add(null);

    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {

        database.add(new Person(4, "Gosheto"));

        Person[] people = database.getElements();

        Assert.assertEquals(people.length, PEOPLE.length + 1);

        Assert.assertEquals(people[people.length - 1].getId(), 4);

        Assert.assertEquals(people[people.length - 1].getUsername(), "Gosheto");
    }

    @Test
    public void testRemoveShouldRemoveLastIndexElement() throws OperationNotSupportedException {

        database.remove();

        Person[] elements = database.getElements();

        Assert.assertEquals(elements[elements.length - 1].getId(), 2);

        Assert.assertEquals(elements[elements.length - 1].getUsername(), "Pesho");

        Assert.assertEquals(elements.length, PEOPLE.length - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExceptionWhenEmpty() throws OperationNotSupportedException {
        for (int i = 0; i <= PEOPLE.length; i++) { // throws exception cuz of the <=
            database.remove();
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testUserEqualsNullThrowsException() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testUserInvalidUsernameThrowsException() throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("Pesho");
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Person petar = database.findByUsername("Pesho");

        Assert.assertEquals(petar.getUsername(), "Pesho");

        Assert.assertEquals(petar.getId(), 2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameEmptyDatabaseThrowsException() throws OperationNotSupportedException {

        Person person = new Person(2, "Pesho");

        database.add(person);
        database.findByUsername("Pesho");
    }

    @Test
    public void testFindById() throws OperationNotSupportedException {

        Person person = database.findById(1);

        Assert.assertEquals(person.getId(), 1);

        Assert.assertEquals(person.getUsername(), "Boris");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdMoreThanONeId() throws OperationNotSupportedException {
        database.add(new Person(2, "Pesho"));

        database.findById(2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdEmptyData() throws OperationNotSupportedException {
        database = new Database();
        database.findById(3);
    }
}