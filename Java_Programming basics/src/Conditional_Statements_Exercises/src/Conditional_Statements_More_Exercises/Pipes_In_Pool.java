package Conditional_Statements_More_Exercises;

import java.util.Scanner;

public class Pipes_In_Pool {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int p1 = scanner.nextInt();
        int p2 = scanner.nextInt();
        double h = scanner.nextDouble();
        double totalDebit = h * p1 + h * p2;
        double percentFull = totalDebit / v * 100.00;
        double percentP1 = (h * p1) / totalDebit * 100.00;
        double percentP2 = (h * p2) / totalDebit * 100.00;
        String percentSign = "%";
        var overflow = (totalDebit > v);


       if (!overflow){
           System.out.printf("The pool is %.2f%s full. Pipe 1: %.2f%s. Pipe 2: %.2f%s.", percentFull, percentSign,
                   percentP1, percentSign, percentP2, percentSign);
       }

       else{
           double total = totalDebit - v;
           System.out.println("For " + h + " hours the pool overflows with " + total + " liters.");
       }

    }
}