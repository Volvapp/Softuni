package Conditional_Statements_Advanced_More_Exercises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Сезон	        Хризантеми	      Рози	          Лалета
        //Пролет / Лято	2.00 лв./бр.	4.10 лв./бр.	2.50 лв./бр.
        //Есен / Зима	3.75 лв./бр.	4.50 лв./бр.	4.15 лв./бр.

        int bouquetPackaging = 2;
        int chrysanthemumsCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int tulipsCount = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holidayYorN = scanner.nextLine();
        double chrysanthemumsPrice = 0;
        double rosesPrice = 0;
        double tulipsPrice = 0;
        double sumThree = 0;
        double sumThreeCount = chrysanthemumsCount + rosesCount + tulipsCount;


        switch (season) {
            case "Spring":
            case "Summer":
                chrysanthemumsPrice = chrysanthemumsCount * 2;
                rosesPrice = rosesCount * 4.10;
                tulipsPrice = tulipsCount * 2.50;
                sumThree = (rosesPrice + tulipsPrice + chrysanthemumsPrice);

                if (tulipsCount >= 7 && season.equals("Spring")) {
                    sumThree = sumThree * 0.95;

                }
                if (sumThreeCount >= 20) {
                    sumThree = sumThree * 0.80;
                }
                if (holidayYorN.equals("Y")) {
                    sumThree = sumThree * 1.15;

                }
                break;
            case "Winter":
            case "Autumn":
                chrysanthemumsPrice = chrysanthemumsCount * 3.75;
                rosesPrice = rosesCount * 4.50;
                tulipsPrice = tulipsCount * 4.15;
                sumThree = (rosesPrice + tulipsPrice + chrysanthemumsPrice);
                if (rosesCount >= 10 && season.equals("Winter")) {
                    sumThree = sumThree * 0.90;
                }
                if (sumThreeCount >= 20) {
                    sumThree = sumThree * 0.80;
                }
                if (holidayYorN.equals("Y")) {
                    sumThree = sumThree * 1.15;
                }
        }sumThree = sumThree + bouquetPackaging;
        System.out.printf("%.2f", sumThree);
    }
}
