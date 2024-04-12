package Exam_Prep;

import java.util.Scanner;

public class Barcode_Generator {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());
        int startUnits = startNum % 10;
        int startTens = startNum / 10 % 10;
        int startHundreds = startNum / 100 % 10;
        int startThousands = startNum / 1000;
        int endUnits = endNum % 10;
        int endTens = endNum / 10 % 10;
        int endHundreds = endNum / 100 % 10;
        int endThousands = endNum / 1000;

        for (int i = startNum; i <= endNum; i++) {
            int units = i % 10;
            int tens = i / 10 % 10;
            int hundreds = i / 100 % 10;
            int thousands = i / 1000;

            if (units % 2 != 0 && tens % 2 != 0 && hundreds % 2 != 0 && thousands % 2 != 0 && units >= startUnits && units <= endUnits
                    && tens >= startTens && tens <= endTens && hundreds >= startHundreds && hundreds <= endHundreds
                    && thousands >= startThousands && thousands <= endThousands) {

                System.out.print(i + " ");
            }
        }
    }
}

