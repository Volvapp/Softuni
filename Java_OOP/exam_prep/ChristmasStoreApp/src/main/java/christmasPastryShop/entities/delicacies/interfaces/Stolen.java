package christmasPastryShop.entities.delicacies.interfaces;

public class Stolen extends BaseDelicacy{
    private static final double INIT_PORTION = 250;
    public Stolen(String name,double price) {
        super(name, INIT_PORTION, price);
    }
}
