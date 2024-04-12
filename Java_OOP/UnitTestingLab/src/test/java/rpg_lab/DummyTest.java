package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {


    @Test
    public void testDummyLosesHealthWhenAttacked() {
        Axe axe = new Axe(1, 10);
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(axe.getAttackPoints());
        Assert.assertEquals(9, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyAttackThrowsException() {
        Axe axe = new Axe(100, 100);
        Dummy dummy = new Dummy(0, 0);

        axe.attack(dummy);
    }

    @Test
    public void testDeadDummyGivesExp() {
        Dummy dummy = new Dummy(0, 80);

        Assert.assertEquals(80, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void TestAliveDummyGivesExp() {
        Dummy dummy = new Dummy(1024, 100);

        Assert.assertEquals(100, dummy.giveExperience());
    }
}