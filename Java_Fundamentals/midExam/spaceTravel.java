package midExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class spaceTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputLine =
                Arrays.stream(scanner.nextLine().split("\\|\\|")).collect(Collectors.toList());
        int fuel = Integer.parseInt(scanner.nextLine());
        int ammunition = Integer.parseInt(scanner.nextLine());
        boolean isFailed = false;

        for (int i = 0; i <= inputLine.size() - 1; i++) {
            String[] commands = inputLine.get(i).split(" ");
            switch (commands[0]) {
                case "Travel":
                    int lightYears = Integer.parseInt(commands[1]);
                    if (fuel < lightYears) {
                        System.out.printf("Mission failed.%n");
                        isFailed = true;
                        break;
                    } else {
                        fuel = fuel - lightYears;
                        System.out.printf("The spaceship travelled %d light-years.%n", lightYears);

                    }
                    break;
                case "Enemy":
                    int enemyArmour = Integer.parseInt(commands[1]);
                    if (ammunition >= enemyArmour) {
                        ammunition -= enemyArmour;
                        System.out.printf("An enemy with %d armour is defeated.%n", enemyArmour);
                    } else {
                        if (fuel - (2 * enemyArmour) > 0) {
                            fuel = fuel - (2 * enemyArmour);
                            System.out.printf("An enemy with %d armour is outmaneuvered.%n", enemyArmour);
                        } else {
                            System.out.printf("Mission failed.%n");
                            isFailed = true;
                            break;
                        }
                    }
                    break;
                case "Repair":
                    int additionalFuel = Integer.parseInt(commands[1]);
                    int additionalAmmo = additionalFuel * 2;
                    fuel += additionalFuel;
                    ammunition += additionalAmmo;
                    System.out.printf("Ammunitions added: %d.%n", additionalAmmo);
                    System.out.printf("Fuel added: %d.%n", additionalFuel);
                    break;
                default:
                    System.out.println("You have reached Titan, all passengers are safe.");
                    return;

            }
            if (isFailed) {
                break;
            }
        }

    }
}
