package petStore;

import org.junit.Assert;
import org.junit.Test;

public class PetStoreTests {
    PetStore petStore = new PetStore();
    Animal animal1 = new Animal("asd", 120, 24.5);
    Animal animal2 = new Animal("agdsgd", 140, 27.6);
    Animal animal3 = new Animal("Doggo", 70, 482.3);

    @Test
    public void testGetAnimals() {
        Assert.assertEquals(0, petStore.getAnimals().size());
        petStore.addAnimal(animal1);
        Assert.assertEquals(1, petStore.getAnimals().size());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKg() {
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(1, petStore.findAllAnimalsWithMaxKilograms(121).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalIsNullThrowsException() {
        petStore.addAnimal(null);
    }

    @Test
    public void testGetTheMostExpensiveAnimalNoAnimal() {
        Assert.assertNull(petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {
        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(animal3, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testFindAllAnimalBySpecie() {
        petStore.addAnimal(animal3);
        Assert.assertEquals(1, petStore.findAllAnimalBySpecie("Doggo").size());

    }
}

