package Exam;

import java.util.Scanner;

public class Sum_And_Product {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //•	a се мени от 1 до 9
        //•	b се мени от 9 до а
        //•	c се мени от 0 до 9
        //•	d се мени от 9 до c

        for (int a = 1; a <= 9; a++) {
            for (int b = 9; b >= a; b--) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 9; d >= c; d--) {
                        if (a + b + c + d == a * b * c * d && n % 10 == 5) {
                            System.out.printf("%d%d%d%d", a, b, c, d);
                            return;
                        } else if ((a * b * c * d) / (a + b + c + d) == 3 && n % 3 == 0) {
                            System.out.printf("%d%d%d%d ", d, c, b, a);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Nothing found");
    }
}