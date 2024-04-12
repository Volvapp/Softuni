package exerciseDataTypesAndVariables;

import java.util.Scanner;

public class spiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine()); //possible to mine for the first day (-10 every following day)
        int dayCounter = 0;
        int spices = 0;

        while (startingYield > 0) {

            if (startingYield < 100) {
                if (spices < 26) {
                    break;
                }
                spices -= 26;
                break;
            }
            dayCounter++;
            spices += startingYield - 26;
            startingYield -= 10;
        }
        System.out.println(dayCounter);
        System.out.println(spices);
    }
}
