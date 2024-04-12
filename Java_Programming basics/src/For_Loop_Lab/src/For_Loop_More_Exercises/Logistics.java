package For_Loop_More_Exercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double loadCount = Double.parseDouble(scanner.nextLine());
        double microbus = 0;
        double truck = 0;
        double train = 0;
        double averagePerTon = 0;
        double percentage = 0;
        double sumAllLoad = 0;
        //До 3 тона – микробус (200 лева на тон)
        //От 4 до 11 тона – камион (175 лева на тон)
        //12 и повече тона – влак (120 лева на тон)

        for (int i = 1; i <= loadCount; i++) {
            double loadType = Double.parseDouble(scanner.nextLine());
            sumAllLoad = sumAllLoad + loadType;

            if (loadType <= 3) {
                microbus = microbus + loadType;
            } else if (loadType <= 11) {
                truck = truck + loadType;
            } else {
                train = train + loadType;

            }
        }
        averagePerTon = (microbus * 200 + truck * 175 + train * 120) / sumAllLoad;

        double percentageMicrobus = microbus / sumAllLoad * 100;
        double percentageTruck = truck / sumAllLoad * 100;
        double percentageTrain = train / sumAllLoad * 100;

        System.out.printf("%.2f%n", averagePerTon);
        System.out.printf("%.2f%%%n", percentageMicrobus);
        System.out.printf("%.2f%%%n", percentageTruck);
        System.out.printf("%.2f%%", percentageTrain);
    }
}