package polymorphismLab.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] animalInfo = scanner.nextLine().split("\\s+");
        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();


        while (!animalInfo[0].equals("End")) {
            Animal animal = null;
            Food food;
            String[] foodInfo = scanner.nextLine().split("\\s+");

            String animalName = animalInfo[1];
            String animalType = animalInfo[0];
            double animalWeight = Double.parseDouble(animalInfo[2]);
            String animalLivingRegion = animalInfo[3];

            switch (animalType) {
                case "Cat":
                    String breed = animalInfo[4];
                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
                    animals.add(animal);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    animals.add(animal);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    animals.add(animal);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    animals.add(animal);
                    break;
                default:
                    System.out.println("No such typeOfAnimal");
            }

            food = getFood(foodInfo);
            foods.add(food);


            animalInfo = scanner.nextLine().split("\\s+");
        }
        for (int i = 0; i < animals.size(); i++) {
            animals.get(i).makeSound();
            animals.get(i).eat(foods.get(i));

        }
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }

    }

    private static Food getFood(String[] foodInfo) {
        Food food = null;
        String foodType = foodInfo[0];
        Integer foodQuantity = Integer.parseInt(foodInfo[1]);
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "Meat":
                food = new Meat(foodQuantity);
                break;
            default:
                System.out.println("No such type of food!");
        }
        return food;
    }
}
