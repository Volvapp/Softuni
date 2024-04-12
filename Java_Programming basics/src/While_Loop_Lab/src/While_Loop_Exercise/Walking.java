package While_Loop_Exercise;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int targetSteps = 10000;
        int reachedSteps = 0;
        while (!command.equals("Going home")){
            int currentSteps = Integer.parseInt(command);

            reachedSteps += currentSteps;

            if (reachedSteps >= targetSteps){
                break;
            }
            command = scanner.nextLine();
        }

        if (command.equals("Going home")){
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            reachedSteps += stepsToHome;
        }
        int diff = Math.abs(reachedSteps - targetSteps);
        if (reachedSteps >= targetSteps){
            System.out.printf("Goal reached! Good job!%n" +
                    " %d steps over the goal!%n", diff);
        }else System.out.printf("%d more steps to reach goal.", diff);
    }
}
