package midExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class arrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String inputLine = scanner.nextLine();

        while (!inputLine.equals("end")) {
            String[] commands = inputLine.split(" ");
            if (commands[0].equals("swap")) {
                int firstIndex = Integer.parseInt(commands[1]);
                int secondIndex = Integer.parseInt(commands[2]);

                int firstNum = numbersArr[firstIndex];
                int secondNum = numbersArr[secondIndex];

                numbersArr[firstIndex] = secondNum;
                numbersArr[secondIndex] = firstNum;
            } else if (commands[0].equals("multiply")) {
                int firstIndex = Integer.parseInt(commands[1]);
                int secondIndex = Integer.parseInt(commands[2]);

                int firstNum = numbersArr[firstIndex];
                int secondNum = numbersArr[secondIndex];

                numbersArr[firstIndex] = firstNum * secondNum;
            } else if (commands[0].equals("decrease")) {
                for (int i = 0; i <= numbersArr.length - 1; i++) {
                    int currentNum = numbersArr[i] - 1;
                    numbersArr[i] = currentNum;
                }
            }

            inputLine = scanner.nextLine();
        }
        for (int i = 0; i <= numbersArr.length - 1; i++) {
            int currentNum = numbersArr[i];
            System.out.print(currentNum);
            if (i != numbersArr.length - 1){
                System.out.print(", ");
            }
        }
    }
}
