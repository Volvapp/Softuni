package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{
    private static final int KG = 7;
    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, KG, price);
    }

    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 1);
    }
}
