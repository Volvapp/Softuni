package christmasPastryShop.entities.cocktails.interfaces;

public class MulledWine extends BaseCocktail{
    private static final double PRICE = 3.5;
    public MulledWine(String name, int size, String brand) {
        super(name, size, PRICE, brand);
    }
}
