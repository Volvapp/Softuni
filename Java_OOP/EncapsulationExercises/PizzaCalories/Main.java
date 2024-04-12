package EncapsulationExercises.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {


            String[] pizzaAndToppings = scanner.nextLine().split("\\s+");
            String pizzaName = pizzaAndToppings[1];
            int numOfToppings = Integer.parseInt(pizzaAndToppings[2]);

            Pizza pizza = new Pizza(pizzaName, numOfToppings);

            String[] doughInfo = scanner.nextLine().split("\\s+");
            String flourType = doughInfo[1];
            String bakingTechnique = doughInfo[2];
            int weight = Integer.parseInt(doughInfo[3]);

            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);
            String toppings = scanner.nextLine();

            while (!toppings.equals("END")) {
                String toppingType = toppings.split("\\s+")[1];
                int weightInGrams = Integer.parseInt(toppings.split("\\s+")[2]);

                Topping topping = new Topping(toppingType, weightInGrams);
                pizza.addTopping(topping);

                toppings = scanner.nextLine();
            }
            System.out.println(pizza.toString());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
