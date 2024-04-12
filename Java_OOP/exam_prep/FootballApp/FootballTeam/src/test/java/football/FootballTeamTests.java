package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class FootballTeamTests {
    private FootballTeam footballTeam;
    private final String name = "Bas";
    private final int vacationPositions = 12;
    private Collection<Footballer> footballers;
    private Footballer footballer = new Footballer("Pencho");

    @Before
    public void setup() {
        footballTeam = new FootballTeam(name, vacationPositions);
        footballers = new ArrayList<>();
        footballers.add(footballer);
    }

    @Test
    public void testConstructor() {
        footballTeam = new FootballTeam(name, vacationPositions);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Bas", footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameIsNullThrowsException() {
        footballTeam = new FootballTeam(null, vacationPositions);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameIsWhitespaces(){
        footballTeam = new FootballTeam("    ", vacationPositions);
    }

    @Test
    public void testSetNameValid() {
        footballTeam = new FootballTeam(this.name, this.vacationPositions);
    }

    @Test
    public void testGetVacationPositions() {
        Assert.assertEquals(12, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVacationPositionsNegativeNumberThrowsException() {
        footballTeam = new FootballTeam(name, -34);
    }

    @Test
    public void testSetVacationValid() {
        footballTeam = new FootballTeam(name, vacationPositions);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerTeamIsFullThrowsException() {
        footballTeam = new FootballTeam("dasr", 1);
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer);
    }

    @Test
    public void testAddFootballerValid() {
        Assert.assertEquals(0, footballTeam.getCount());
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1, footballTeam.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerNoSuchFootballerThrowsException() {
        footballTeam.removeFootballer("dragan");
    }

    @Test
    public void testRemoveFootballerValid() {
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1, footballTeam.getCount());
        footballTeam.removeFootballer(footballer.getName());
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleNoSuchFootballerException() {
        footballTeam.footballerForSale("Gencho");
    }

    @Test
    public void testFootballerForSale() {
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(footballer, footballTeam.footballerForSale("Pencho"));
        Assert.assertFalse(footballer.isActive());
    }

    @Test
    public void testGetStatistics() {
        footballTeam.addFootballer(footballer);
        Assert.assertEquals("The footballer Pencho is in the team Bas.", footballTeam.getStatistics());
    }
}
