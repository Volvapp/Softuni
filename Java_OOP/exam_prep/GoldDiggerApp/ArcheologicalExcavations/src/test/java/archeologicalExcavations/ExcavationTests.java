package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ExcavationTests {
    Excavation excavation;
    Collection<Archaeologist> archaeologists;
    private Archaeologist archaeologist1;


    @Before
    public void setup() {
        excavation = new Excavation("exc", 20);
        archaeologist1 = new Archaeologist("Borko", 15);
        archaeologists = new ArrayList<>();
    }

    @Test
    public void testGetCount() {
        excavation.addArchaeologist(archaeologists.stream().findFirst().orElse(null));
        Assert.assertEquals(1, excavation.getCount());
    }

    @Test
    public void testGetName() {
        excavation.addArchaeologist(archaeologists.stream().findFirst().orElse(null));
        Assert.assertEquals("exc", excavation.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(20, excavation.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistNoMoreExcavationThrowsException() {
        Excavation emptyExcavation = new Excavation("ssc", 0);
        emptyExcavation.addArchaeologist(archaeologist1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistExistsThrowsException() {
        Excavation excavation1 = new Excavation("pp", 2);
        excavation1.addArchaeologist(archaeologist1);
        excavation1.addArchaeologist(archaeologist1);
    }

    @Test
    public void testRemoveArchaeologistIsExist() {
        String name = archaeologist1.getName();
        excavation.addArchaeologist(archaeologist1);
        Assert.assertEquals(1, excavation.getCount());
        excavation.removeArchaeologist(name);
        Assert.assertEquals(0, excavation.getCount());

    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetCapacityBelowZeroThrowsException(){
        excavation = new Excavation("Boreto", -2);
    }
    @Test
    public void testSetCapacity(){
        excavation = new Excavation("boretti", 35);
    }
    @Test (expected = NullPointerException.class)
    public void testSetNameIsEmptyThrowsException(){
        excavation = new Excavation("", 5);
    }
    @Test
    public void testSetName(){
        excavation = new Excavation("asdasf", 25);
    }
}
