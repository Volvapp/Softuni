package midExam;

import java.util.Scanner;

public class theBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cookiesPerWorkerADay = Integer.parseInt(scanner.nextLine());
        int countWorkers = Integer.parseInt(scanner.nextLine());
        int competingFactoryBiscuits = Integer.parseInt(scanner.nextLine());

        double cookiesPerDayAllWorkers = cookiesPerWorkerADay * countWorkers;
        int allBiscuits = 0;

        for (int days = 1; days <= 30; days++) {
            double thirdDayBiscuits = 0;
            if (days % 3 == 0){
                thirdDayBiscuits = cookiesPerDayAllWorkers * 0.75;
                allBiscuits += Math.floor(thirdDayBiscuits);
                continue;
            }
            allBiscuits += cookiesPerDayAllWorkers;
        }
        System.out.println("You have produced " + allBiscuits + " biscuits for the past month.");
        double dif = allBiscuits - competingFactoryBiscuits;
        double percent = dif / competingFactoryBiscuits * 100;
        if (allBiscuits > competingFactoryBiscuits){
            System.out.printf("You produce %.2f percent more biscuits.", percent);
        }else {
            System.out.printf("You produce %.2f percent less biscuits.", Math.abs(percent));
        }
    }
}
