package listLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class listManipulationsAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commands = input.split(" ");
            String command1 = commands[0];
            String command2 = commands[1];

            if (command1.equals("Contains")) {
                boolean isContained = false;
                for (int i = 0; i <= numbersList.size() - 1; i++) {
                    int currentNum = numbersList.get(i);

                    if (currentNum == Integer.parseInt(command2)) {
                        isContained = true;
                        break;
                    }
                }
                if (isContained) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (command1.equals("Filter")) {
                int command3 = Integer.parseInt(commands[2]);
                for (int i = 0; i <= numbersList.size() - 1; i++) {
                    int currentNum = numbersList.get(i);
                    if (command2.equals(">") && command3 < currentNum) {
                        System.out.println(currentNum + " ");
                    } else if (command2.equals("<") && command3 > currentNum) {
                        System.out.print(currentNum + " ");
                    } else if (command2.equals(">=") && command3 <= currentNum) {
                        System.out.print(currentNum + " ");
                    } else if (command2.equals("<=") && command3 >= currentNum) {
                        System.out.print(currentNum + " ");
                    }
                }
                System.out.println();
            } else if (command1.equals("Print") && command2.equals("even")) {
                for (int i = 0; i <= numbersList.size() - 1; i++) {
                    int currentNum = numbersList.get(i);
                    if (currentNum % 2 == 0) {
                        System.out.print(currentNum + " ");
                    }
                }
                System.out.println();
            } else if (command1.equals("Print") && command2.equals("odd")) {
                for (int i = 0; i <= numbersList.size() - 1; i++) {
                    int currentNum = numbersList.get(i);
                    if (currentNum % 2 != 0) {
                        System.out.print(currentNum + " ");
                    }
                }
                System.out.println();
            } else if (command1.equals("Get") && command2.equals("sum")) {
                int result = 0;
                for (int i = 0; i <= numbersList.size() - 1; i++) {
                    int currentNum = numbersList.get(i);
                    result += currentNum;

                }
                System.out.println(result);
            }
            input = scanner.nextLine();
        }
    }
}
