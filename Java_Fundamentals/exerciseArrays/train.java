package exerciseArrays;

import java.util.Scanner;

public class train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWagons = Integer.parseInt(scanner.nextLine());
        int [] passengersArr = new int[numberOfWagons];
        int sum = 0;
        for (int i = 0; i < numberOfWagons; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            passengersArr[i] = currentNum;
            sum += currentNum;
        }
        for (int i : passengersArr) {
            System.out.printf("%d ", i);
        }
        System.out.printf("%n%d", sum);
    }
}
