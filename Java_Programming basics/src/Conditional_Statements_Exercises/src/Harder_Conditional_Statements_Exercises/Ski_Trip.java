package Harder_Conditional_Statements_Exercises;

import java.util.Scanner;

public class Ski_Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"room for one person" – 18.00 лв за нощувка
        //"apartment" – 25.00 лв за нощувка
        //"president apartment" – 35.00 лв за нощувка

        //вид помещение	        /по-малко от 10 дни	    /между 10 и 15 дни	    /повече от 15 дни
        //room for one person	/не ползва намаление	/не ползва намаление    /не ползва намаление
        //apartment	            /30% от крайната цена	/35% от крайната цена	/50% от крайната цена
        //president apartment	/10% от крайната цена	/15% от крайната цена	/20% от крайната цена

        //10 дни -> 9 нощувки

        // Ако оценката му е позитивна, към цената с вече приспаднатото намаление
        // Атанас добавя 25% от нея. Ако оценката му е негативна приспада от цената 10%.

        int daysInHotel = Integer.parseInt(scanner.nextLine());
        String typeRoom = scanner.nextLine();
        String mark = scanner.nextLine();
        double price = 0;
        double moneyForTrip = 0;


        switch (typeRoom) {
            case "room for one person":
                if (daysInHotel <= 10) {
                    price = 18;
                } else if (daysInHotel <= 15) {
                    price = 18;
                } else {
                    price = 18;
                }
                break;
            case "apartment":
                if (daysInHotel <= 10) {
                    price = 25.00 * 0.70;
                } else if (daysInHotel <= 15) {
                    price = 25 * 0.65;
                } else {
                    price = 25 * 0.5;
                }break;
        case "president apartment":
                if (daysInHotel <= 10) {
                    price = 35 * 0.90;
                } else if (daysInHotel <= 15) {
                    price = 35 * 0.85;
                } else {
                    price = 35 * 0.80;
                }break;
        }
        double nights = daysInHotel - 1;
        moneyForTrip = price * nights;
        if (mark.equals("positive")) {
            moneyForTrip = moneyForTrip + moneyForTrip * 0.25;
        } else {
            moneyForTrip = moneyForTrip - moneyForTrip * 0.10;

        }
        System.out.printf("%.2f", moneyForTrip);
    }
}


