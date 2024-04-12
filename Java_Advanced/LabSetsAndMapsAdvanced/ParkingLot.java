package LabSetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commands = scanner.nextLine();

        Set<String> set = new LinkedHashSet<>();

        while (!commands.equals("END")) {
            String[] parts = commands.split(", ");
            String move = parts[0];
            String carPlate = parts[1];

            if (move.equals("IN")) {
                set.add(carPlate);
            } else if (move.equals("OUT")) {
                set.remove(carPlate);
            }


            commands = scanner.nextLine();
        }
        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String element : set) {
                System.out.println(element);
            }
        }
    }
}
