package Conditional_Statements_More_Exercises;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //През 10% от дните служителите са на обучение и не могат да работят по проекта.
        //Един нормален работен ден във фирмата е 8 часа.
        // Всеки служител може да работи по проекта в извънработно време по 2 часа на ден.

        int neededHours = Integer.parseInt(scanner.nextLine());
        int disposeDays = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        double studyPercent = disposeDays - disposeDays * 0.10;
        double workDay = 8;
        double workWeek = workDay * studyPercent;
        double offTime = workers * 2 * disposeDays;
        double sum = Math.floor(workWeek + offTime);
        double diff = Math.abs(neededHours - sum);
        if (neededHours <= sum){
            System.out.printf("Yes!%.0f hours left.", diff);
        }else System.out.printf("Not enough time!%.0f hours needed.", diff);

    }
}
