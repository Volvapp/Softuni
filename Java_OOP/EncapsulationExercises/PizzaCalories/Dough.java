package EncapsulationExercises.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight > 200 || weight < 1){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double flourMultiplier = 0;
        if (this.flourType.equals("white")) {
            flourMultiplier = 1.5;
        } else if (this.flourType.equals("Wholegrain")){
            flourMultiplier = 1;
        }
        double bakingFlourMultiplier = 0;
        switch (this.bakingTechnique) {
            case "Crispy":
                bakingFlourMultiplier = 0.9;
                break;
            case "Chewy":
                bakingFlourMultiplier = 1.1;
                break;
            case "Homemade":
                bakingFlourMultiplier = 1;
                break;
        }
        return (2 * this.weight) * flourMultiplier * bakingFlourMultiplier;
    }
}
