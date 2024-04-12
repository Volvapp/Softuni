package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
    private static final double INIT_KG = 2.5;
    private static final double ADDITIONAL_KG = 7.5;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INIT_KG, price);

    }

    @Override
    public void eat() {
        this.setKg(getKg() + ADDITIONAL_KG);
    }
}
