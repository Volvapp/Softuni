package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class GarageTests {
    Garage garage;
    private Collection<Car> cars;
    Car car1;
    Car car2;
    Car car3;

    @Before
    public void setup() {
        garage = new Garage();
        cars = new ArrayList<>();
        car1 = (new Car("Merkeles", 120, 2000));// na lizing
        car2 = (new Car("sitroin", 320, 15000)); // sexu
        car3 = (new Car("Avdu", 500, 20000)); //extri bol // kuatru
    }

    @Test
    public void testGetCars() {

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        Assert.assertEquals(3, garage.getCars().size());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, garage.getCount());
    }

    @Test
    public void testFindALlCarsWithMaxSpeedAbove() {
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        cars.add(car3);

        Assert.assertEquals(cars, garage.findAllCarsWithMaxSpeedAbove(400));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarNullThrowsException() {
        garage.addCar(null);
    }
    @Test
    public void testAddCar(){
        garage.addCar(car1);
        Assert.assertEquals(car1, garage.getCars().get(0));
    }
    @Test
    public void testGetMostExpensiveCar(){
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(car3, garage.getTheMostExpensiveCar());
    }
    @Test
    public void testGetMostExpensiveCarNull(){
        Assert.assertNull(garage.getTheMostExpensiveCar());
    }
    @Test
    public void testFindAllByBrand(){
        cars.add(car1);

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(cars, garage.findAllCarsByBrand("Merkeles"));
    }
}