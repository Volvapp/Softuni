package methodsLab;

import java.util.Scanner;

public class multiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(number(number));

    }

    public static int number(int num) {
        int abs = Math.abs(num);
        String[] number = String.valueOf(abs).split("");
        int even = 0;
        int odd = 0;
        for (String text : number) {


            for (int i = 0; i < text.length(); i++) {
                int currentNum = Integer.parseInt(text);

                if (currentNum % 2 == 0) {
                    even += currentNum;
                } else {
                    odd += currentNum;
                }
            }
        }
        return even * odd;
    }
}

