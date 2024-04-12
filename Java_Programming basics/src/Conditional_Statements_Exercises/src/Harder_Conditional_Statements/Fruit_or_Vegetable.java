package Harder_Conditional_Statements;

import java.util.Scanner;

public class Fruit_or_Vegetable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Плодовете "fruit" са banana, apple, kiwi, cherry, lemon и grapes
        //Зеленчуците "vegetable" са tomato, cucumber, pepper и carrot
        //Всички останали са "unknown"
        String product = scanner.nextLine();
        switch (product) {
            case "banana":
            case "kiwi":
            case "grapes":
            case "cherry":
            case "apple":
            case "lemon":
                System.out.println("fruit");
                break;
            case "tomato":
            case "cucumber":
            case "pepper":
            case "carrot":
                System.out.println("vegetable");
                break;
            default:
                System.out.println("unknown");

        }
    }
}

