package For_Loop_More_Exercises;

import java.util.Scanner;

public class Back_To_The_Past {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heritage = Double.parseDouble(scanner.nextLine());
        int yearsToLive = Integer.parseInt(scanner.nextLine());
        int IvanchoYears = 18;
        double money = 0;


        for (int i = 1800; i <= yearsToLive; i++) {
            if (IvanchoYears % 2 == 0) {
                money += 12000;
            } else {
                money += 12000 + 50 * IvanchoYears;
            }
            IvanchoYears++;
        }
        double diff;

        if (heritage >= money) {
            diff = Math.abs(heritage - money);
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", diff);
        }else {
            diff = Math.abs(money - heritage);
            System.out.printf("He will need %.2f dollars to survive.", diff);
        }
    }
}
