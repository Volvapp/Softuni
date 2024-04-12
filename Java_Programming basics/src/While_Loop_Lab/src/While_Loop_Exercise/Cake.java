package While_Loop_Exercise;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int cakeSize = width * length;



        while (!command.equals("STOP")) {
            int pieces = Integer.parseInt(command);
            cakeSize = cakeSize - pieces;

            if (cakeSize < 0){
                break;
            }
            command = scanner.nextLine();
        }
        if (cakeSize <= 0) {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakeSize));
        }else {
            System.out.printf("%d pieces are left.", cakeSize);
        }
    }
}