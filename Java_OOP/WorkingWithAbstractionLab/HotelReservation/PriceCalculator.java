package WorkingWithAbstractionLab.HotelReservation;

public class PriceCalculator {
    public static double calculatePrice(double pricePerDay, int numOfDays, Season season, Discount discount) {

        double basePrice = pricePerDay * numOfDays * season.getMultiplier();

        return basePrice * (1 - discount.getDiscount());
    }
}
