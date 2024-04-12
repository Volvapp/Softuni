package basicSyntaxExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPeople = Integer.parseInt(scanner.nextLine());
        String typePeople = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double singlePersonTicket = 0;
        double totalPrice = 0;
        //          Friday	   Saturday	    Sunday
        //Students	8.45	    9.80	    10.46
        //Business	10.90	    15.60	    16
        //Regular	15	          20	    22.50
        //•	Students – if the group is bigger than or equal to 30 people, you should reduce the total price by 15%
        //•	Business – if the group is bigger than or equal to 100 people 10 of them can stay for free.
        //•	Regular – if the group is bigger than or equal to 10 and less than or equal to 20 reduce the total price by 5%

        if (typePeople.equals("Students")) {
            if (dayOfWeek.equals("Friday")) {
                singlePersonTicket = 8.45;
            } else if (dayOfWeek.equals("Saturday")) {
                singlePersonTicket = 9.80;
            } else if (dayOfWeek.equals("Sunday")) {
                singlePersonTicket = 10.46;
            }
            totalPrice = numOfPeople * singlePersonTicket;
            if (numOfPeople >= 30) {
                totalPrice = totalPrice * 0.85;
            }
            System.out.printf("Total price: %.2f", totalPrice);
        } else if (typePeople.equals("Business")) {
            if (dayOfWeek.equals("Friday")) {
                singlePersonTicket = 10.90;
            } else if (dayOfWeek.equals("Saturday")) {
                singlePersonTicket = 15.60;
            } else if (dayOfWeek.equals("Sunday")) {
                singlePersonTicket = 16;
            }
            if (numOfPeople >= 100) {
                numOfPeople -= 10;
            }
            totalPrice = numOfPeople * singlePersonTicket;
            System.out.printf("Total price: %.2f", totalPrice);
        } else if (typePeople.equals("Regular")) {
            if (dayOfWeek.equals("Friday")) {
                singlePersonTicket = 15;
            } else if (dayOfWeek.equals("Saturday")) {
                singlePersonTicket = 20;
            } else if (dayOfWeek.equals("Sunday")) {
                singlePersonTicket = 22.50;
            }
            totalPrice = numOfPeople * singlePersonTicket;
            if (numOfPeople >= 10 && numOfPeople <= 20) {
                totalPrice = totalPrice * 0.95;
            }
            System.out.printf("Total price: %.2f", totalPrice);
        }
    }
}

