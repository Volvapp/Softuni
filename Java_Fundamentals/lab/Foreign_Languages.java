package lab;

import java.util.Scanner;

public class Foreign_Languages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        switch (country){
            case "USA":
            case"England":
                System.out.println("English");
                break;
            case "Argentina":
            case "Spain":
            case "Mexico":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
        }
    }
}
