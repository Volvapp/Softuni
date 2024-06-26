package exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class arrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {


            if (command.contains("swap")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int element1 = numbers[index1];
                int element2 = numbers[index2];

                numbers[index1] = element2;
                numbers[index2] = element1;

            } else if (command.contains("multiply")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);

                int element1 = numbers[index1];
                int element2 = numbers[index2];

                int result = element1 * element2;
                numbers[index1] = result;

            } else if (command.equals("decrease")) {

                for (int index = 0; index <= numbers.length - 1; index++) {
                    numbers[index]--;
                }


            }


            command = scanner.nextLine();
        }
        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentNum = numbers[index];
            if (index != numbers.length - 1) {
                System.out.print(currentNum + ", ");
            } else {
                System.out.println(currentNum);
            }
        }
    }
}
