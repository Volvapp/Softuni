package EncapsulationExercises.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Sauce":
            case "Cheese":
                this.toppingType = toppingType;
                break;
            default:
                String message = "Cannot place " + toppingType + " on top of your pizza.";
                throw new IllegalArgumentException(message);
        }
    }

    private void setWeight(double weight) {
        if (weight <= 50 && weight >= 1) {
            this.weight = weight;
        } else {
            String message = toppingType + " weight should be in the range [1..50].";
            throw new IllegalArgumentException(message);
        }
    }

    public double calculateCalories() {
        double multiplier = 0;

        switch (this.toppingType) {
            case "Meat":
                multiplier = 1.2;
                break;
            case "Veggies":
                multiplier = 0.8;
                break;
            case "Cheese":
                multiplier = 1.1;
                break;
            case "Sauce":
                multiplier = 0.9;
                break;
        }
        return (2 * weight) * multiplier;
    }
}
