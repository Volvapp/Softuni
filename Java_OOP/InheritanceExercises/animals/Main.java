package InheritanceExercises.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();

        while (!animalType.equals("Beast!")) {

            String[] animalParameters = scanner.nextLine().split("\\s+");
            try {


                switch (animalType) {
                    case "Cat":
                        System.out.println(new Cat(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]).toString());
                        break;
                    case "Dog":
                        System.out.println(new Dog(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]).toString());
                        break;
                    case "Frog":
                        System.out.println(new Frog(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]).toString());
                        break;
                    case "Kitten":
                        System.out.println(new Kitten(animalParameters[0], Integer.parseInt(animalParameters[1])));
                        break;
                    case "Tomcat":
                        System.out.println(new Tomcat(animalParameters[0], Integer.parseInt(animalParameters[1])));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }

            animalType = scanner.nextLine();
        }
    }
}
