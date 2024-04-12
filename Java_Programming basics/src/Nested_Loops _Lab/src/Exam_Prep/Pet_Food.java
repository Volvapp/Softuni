package Exam_Prep;

import java.util.Scanner;

public class Pet_Food {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double totalFood = Double.parseDouble(scanner.nextLine());
        double totalBiscuit = 0;
        double totalEatenFood = 0;
        double totalEatenDog = 0;
        double totalEatenCat = 0;

        for (int day = 1; day <= days; day++) {
            int dogFood = Integer.parseInt(scanner.nextLine());
            int catFood = Integer.parseInt(scanner.nextLine());
            int foodPerDay = dogFood + catFood;
            if (day % 3 == 0){
                totalBiscuit += 0.1 * foodPerDay;
            }

            totalEatenFood += foodPerDay;
            totalEatenDog += dogFood;
            totalEatenCat += catFood;
        }
        System.out.printf("Total eaten biscuits: %.0fgr.%n", Math.floor(totalBiscuit));
        double percentEatenFood = totalEatenFood / totalFood * 100;
        System.out.printf("%.2f%% of the food has been eaten.%n", percentEatenFood);
        double percentDog = totalEatenDog / totalEatenFood * 100;
        System.out.printf("%.2f%% eaten from the dog.%n", percentDog);
        double percentCat = totalEatenCat / totalEatenFood * 100;
        System.out.printf("%.2f%% eaten from the cat.", percentCat);
    }
}
