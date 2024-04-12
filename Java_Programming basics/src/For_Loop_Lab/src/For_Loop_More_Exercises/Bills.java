package For_Loop_More_Exercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //За ток – всеки месец е различен, ще се чете от конзолата
        //за вода – 20 лв.
        //за интернет – 15 лв.
        //за други – събират се тока, водата и интернета за месеца и към сумата се прибавят 20%.
        //За всеки разход трябва да се пресметне колко общо е платено за всички месеци.

        int months = Integer.parseInt(scanner.nextLine());
        double waterPrice = 20;
        double internetPrice = 15;
        double electricityMonthly = 0;
        double electricityTotal = 0;
        double waterTotal = 0;
        double internetTotal = 0;
        double elseMonthly = (waterPrice + internetPrice + electricityMonthly);
        double elseTotal = 0;

        for (int i = 1; i <= months; i++) {
            electricityMonthly = Double.parseDouble(scanner.nextLine()); //на месец
            electricityTotal += electricityMonthly;
            elseMonthly = 1.20 * (electricityMonthly + internetPrice + waterPrice);
            elseTotal += elseMonthly;
        }
        waterTotal = waterPrice * months;
        internetTotal = internetPrice * months;
        double sumAll = waterTotal + internetTotal + electricityTotal + elseTotal;
        double average = sumAll / months;
        System.out.printf("Electricity: %.2f lv%n" + "Water: %.2f lv%n" + "Internet: %.2f lv%n" + "Other: %.2f lv%n" + "Average: %.2f lv%n",
                electricityTotal, waterTotal, internetTotal, elseTotal, average);
    }
}
