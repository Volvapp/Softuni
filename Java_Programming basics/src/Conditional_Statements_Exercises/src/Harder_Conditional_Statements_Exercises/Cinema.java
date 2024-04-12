package Harder_Conditional_Statements_Exercises;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       //Premiere – премиерна прожекция, на цена 12.00 лева.
        //Normal – стандартна прожекция, на цена 7.50 лева.
        //Discount – прожекция за деца, ученици и студенти на намалена цена от 5.00 лева.

        String type = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        double income = 0.0;
        if (type.equals("Premiere")){
            income = rows * columns * 12;
        }else if (type.equals("Normal")){
            income = rows * columns * 7.5;
        }else income = rows * columns * 5;
        System.out.println(income);
    }
}

