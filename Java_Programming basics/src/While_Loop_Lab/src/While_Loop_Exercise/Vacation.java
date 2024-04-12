package While_Loop_Exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());
        double finalSum = availableMoney;
        int counterSpend = 0;
        int counterTotalDays = 0;
        boolean isFailed = false;


        while (finalSum < neededMoney) {
            if (counterSpend >= 5) {
                isFailed = true;
                break;
            }
            String action = scanner.nextLine();
            double amount = Double.parseDouble(scanner.nextLine());

            counterTotalDays++;
            if (action.equals("spend")) {
                finalSum = finalSum - amount;
                counterSpend++;
                if (finalSum < 0) {
                    finalSum = 0;
                }
            } else if (action.equals("save")) {
                counterSpend = 0;
                finalSum = finalSum + amount;
            }
        }if (isFailed){
            System.out.println("You can't save the money.");
            System.out.println(counterTotalDays);
        }else {
            System.out.printf("You saved the money for %d days.", counterTotalDays);
        }
    }
}
