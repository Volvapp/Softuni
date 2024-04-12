package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar{
    private static final int MINIMUM_HP = 400;
    private static final int MAXIMUM_HP = 600;
    private static final double CUBIC_CM = 5000;
    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CM);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < MINIMUM_HP || horsePower > MAXIMUM_HP){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
