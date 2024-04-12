package christmasPastryShop.entities.delicacies.interfaces;

public class Gingerbread extends BaseDelicacy{
    private static final double INIT_PORTION = 200;
    public Gingerbread(String name, double price) {
        super(name, INIT_PORTION, price);
    }
}
