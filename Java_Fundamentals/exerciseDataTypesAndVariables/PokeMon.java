package exerciseDataTypesAndVariables;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance =  Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int startingPower = power;
        int countPoke = 0;
        while (power >= distance){
            power -= distance;
            countPoke++;

            if (power == startingPower / 2 && power > 0 && exhaustionFactor != 0){
                power /= exhaustionFactor;

            }if (power < distance){
                System.out.printf("%d%n%d", power, countPoke);
            }

        }
    }
}
