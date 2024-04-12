package Conditional_Statements_More_Exercises;

import java.util.Scanner;

public class Transport_Price {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double taxiStartingPrice = 0.70; // на километър
        double taxiDayPrice = 0.79; // на километър
        double taxiNightPrice = 0.90; // на километър

        double bus = 0.09; // Дневна и нощна тарифа. Може да се използва за разстояния минимум 20 км.

        double train = 0.06; //Дневна и нощна тарифа. Може да се използва за разстояния минимум 100 км.

        if (n < 20) {
            double taxiSumDay = taxiStartingPrice + n * taxiDayPrice;
            double taxiSumNight = taxiStartingPrice + n * taxiNightPrice;

            if (timeOfDay.equals("day")) {
                System.out.printf("%.2f", taxiSumDay);

            }else if (timeOfDay.equals("night")){
                System.out.printf("%.2f", taxiSumNight);
            }
        }else if (n < 100){
            double busSum = bus * n;
            System.out.printf("%.2f", busSum);
        }else {
            double trainSum = train * n;
            System.out.printf("%.2f", trainSum);
        }
    }
}