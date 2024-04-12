package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MagicianTests {
    private Magician magician;
    private List<Magic> magics;
    private Magic magic;


    @Before
    public void setup() {
        magician = new Magician("Magician", 20);
        magic = new Magic("Magic", 200);
        magician.addMagic(magic);
    }

    @Test
    public void testGetUsername() {
        String actualName = magician.getUsername();
        Assert.assertEquals("Magician", actualName);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameNullThrowsException() {
        magician = new Magician(null, 20);
    }

    @Test
    public void testGetHealth() {
        Assert.assertEquals(20, magician.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthThrowsException() {
        magician = new Magician("Petrunko", -1);
    }

    @Test
    public void testGetMagics() {
        magician.getMagics();
    }
    @Test(expected = IllegalStateException.class)
    public void testTakeDamageMagicianIsDeadThrowsException(){
       Magician dead = new Magician("asd", 0);
        dead.takeDamage(5);
    }
    @Test
    public void testTakeDamageHealthLessThanZeroIsZero(){
        magician.takeDamage(25);
        Assert.assertEquals(0, magician.getHealth());
    }
    @Test
    public void testTakeDamage(){
        magician.takeDamage(15);
        Assert.assertEquals(5, magician.getHealth());
    }
    @Test (expected = NullPointerException.class)
    public void addMagicNullThrowsException(){
        magician.addMagic(null);
    }
    @Test
    public void testRemoveMagic(){
        Magic faye = new Magic("Hasbullina", 20);
        magician.addMagic(faye);
        Assert.assertEquals(2, magician.getMagics().size());
        magician.removeMagic(faye);
        Assert.assertEquals(1,magician.getMagics().size());
        Assert.assertEquals(magic, magician.getMagic(magic.getName()));
    }
}