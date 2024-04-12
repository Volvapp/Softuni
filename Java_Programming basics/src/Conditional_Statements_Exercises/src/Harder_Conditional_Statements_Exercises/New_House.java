package Harder_Conditional_Statements_Exercises;

import java.util.Scanner;

public class New_House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Ако Нели купи повече от 80 Рози - 10% отстъпка от крайната цена
        //Ако Нели купи повече от 90  Далии - 15% отстъпка от крайната цена
        //Ако Нели купи повече от 80 Лалета - 15% отстъпка от крайната цена
        //Ако Нели купи по-малко от 120 Нарциса - цената се оскъпява с 15%
        //Ако Нели Купи по-малко от 80 Гладиоли - цената се оскъпява с 20%
        //Вид цветя - текст с възможности - "Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"
        String typeFlower = scanner.nextLine();
        int countFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;
        switch (typeFlower) {
            case "Roses":
                totalPrice = countFlowers * 5.0;
                if (countFlowers > 80) {
                    totalPrice = totalPrice - (totalPrice * 0.10);
                }
                break;
            case "Dahlias":
                totalPrice = countFlowers * 3.80;
                if (countFlowers > 90) {
                    totalPrice = totalPrice - (totalPrice * 0.15);
                }
                break;
            case "Tulips":
                totalPrice = countFlowers * 2.80;
                if (countFlowers > 80) {
                    totalPrice = totalPrice - totalPrice * 0.15;
                }
                break;
            case "Narcissus":
                totalPrice = countFlowers * 3.0;
                if (countFlowers < 120) {
                    totalPrice = totalPrice * 1.15;
                }
                break;
            case "Gladiolus":
                totalPrice = countFlowers * 2.50;
                if (countFlowers < 80) {
                    totalPrice = totalPrice * 1.20;
                }
                break;
        }
        double diff = Math.abs(budget - totalPrice);
        if (budget >= totalPrice) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", countFlowers,typeFlower, diff);
        }else System.out.printf("Not enough money, you need %.2f leva more.", diff);

    }
}
