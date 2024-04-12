package basicSyntaxExercise;

import java.util.Scanner;

public class Pad_Equipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Integer.parseInt(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double singleSaberPrice = Double.parseDouble(scanner.nextLine());
        double singleRobePrice = Double.parseDouble(scanner.nextLine());
        double singleBeltPrice = Double.parseDouble(scanner.nextLine());

        //Because the sabers sometimes break, George Lucas should buy 10% more, rounded up to the next integer.
        // Also, every sixth belt is free.
        double sabers = Math.ceil(countStudents + countStudents * 0.10) * singleSaberPrice;
        double robes = singleRobePrice * countStudents;
        double belts = (countStudents - countStudents / 6) * singleBeltPrice;

        double neededSum = sabers + robes + belts;

        if (money >= neededSum) {
            System.out.printf("The money is enough - it would cost %.2flv.", neededSum);
        } else {
            double remainingMoney = neededSum - money;
            System.out.printf("George Lucas will need %.2flv more.", remainingMoney);
        }
    }
}
