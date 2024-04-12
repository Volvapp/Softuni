package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
    Service service;
    Robot robot1;

    @Before
    public void setup() {
        service = new Service("asd", 12);
        robot1 = new Robot("Peshaka");
        service.add(robot1);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("asd", service.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameIsNullThrowsException() {
        service = new Service(null, 12);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameIsWhiteSpace() {
        service = new Service("", 12);
    }

    @Test
    public void testSetName() {
        service = new Service("asfhgh", 12);
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(12, service.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityLessThanZeroThrowsException() {
        service = new Service("s", -1);
    }

    @Test
    public void testSetCapacity() {
        service = new Service("asfd", 14);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotFullServiceThrowsException() {
        service = new Service("ag", 1);
        service.add(robot1);
        service.add(robot1);
    }

    @Test
    public void testAddRobot() {
        service.add(robot1);
        Assert.assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotNullThrowsException() {
        service.remove("petur");
    }

    @Test
    public void testRemoveRobot() {
        service.remove("Peshaka");
        Assert.assertEquals(0, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleRobotIsNullThrowsException() {
        service.forSale("ash");
    }
    @Test
    public void testForSale(){
        service.forSale("Peshaka");
        Assert.assertFalse(robot1.isReadyForSale());
    }
    @Test
    public void testReport(){
        Assert.assertEquals("The robot Peshaka is in the service asd!", service.report());
    }
}
