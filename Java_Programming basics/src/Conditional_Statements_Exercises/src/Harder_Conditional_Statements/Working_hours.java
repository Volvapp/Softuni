package Harder_Conditional_Statements;

import java.util.Scanner;

public class Working_hours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double hour = Double.parseDouble(scanner.nextLine());
        String day = scanner.nextLine();
        boolean isValid = (hour >= 10 && hour <= 18);
        {
            boolean gay = (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") ||
                    day.equals("Thursday") || day.equals("Friday") || day.equals("Saturday"));
           if (!gay || !isValid){
               System.out.println("closed");
           }
           else {
               System.out.println("open");
           }
        }
    }
}