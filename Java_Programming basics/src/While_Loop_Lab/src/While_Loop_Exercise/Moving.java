package While_Loop_Exercise;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int allSpace = width * length * height;

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            int boxCount = Integer.parseInt(command);

            allSpace = allSpace - boxCount;

            if (allSpace <= 0) {
                break;
            }
            command = scanner.nextLine();

        }
        if (allSpace <= 0) {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(allSpace));
        } else {
            System.out.printf("%d Cubic meters left.", allSpace);
        }
    }
}
