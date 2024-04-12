package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    private static final double INIT_KG = 5.5;
    private static final double ADDITIONAL_KG = 5.7;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind,INIT_KG, price);

    }

    @Override
    public void eat() {
        this.setKg(this.getKg() + ADDITIONAL_KG);
    }
}
