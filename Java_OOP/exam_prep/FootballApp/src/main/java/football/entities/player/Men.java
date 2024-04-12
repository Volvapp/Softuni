package football.entities.player;

public class Men extends BasePlayer {
    private static final double KG = 85.5;
    private static final int ADDITIONAL_STRENGTH = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
        setKg(KG);
    }

    @Override
    public void stimulation()    {
        this.setStrength(this.getStrength() + ADDITIONAL_STRENGTH);
    }
}
