package football.entities.player;

public class Women extends BasePlayer{
    private static final double KG = 60.0;
    private static final int ADDITIONAL_STRENGTH = 115;
    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
        setKg(KG);
    }

    @Override
    public void stimulation() {
        this.setStrength(this.getStrength() + ADDITIONAL_STRENGTH);
    }
}
