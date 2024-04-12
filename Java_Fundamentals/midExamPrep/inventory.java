package midExamPrep;

import java.util.List;
import java.util.Scanner;

public class inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = new java.util.ArrayList<>(List.of(scanner.nextLine().split(", ")));

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Craft!")) {
            String[] commands = inputLine.split(" - ");
            String command = commands[0];
            switch (command) {
                case "Collect":
                    String addItem = commands[1];
                    if (!items.contains(addItem)) {
                        items.add(addItem);
                    }
                    break;
                case "Drop":
                    String removeItem = commands[1];
                    items.remove(removeItem);
                    break;
                case "Combine Items":
                    String[] split = commands[1].split(":");
                    String oldItem = split[0];
                    String newItem = split[1];
                    if (items.contains(oldItem)) {
                        int indexOldItem = items.indexOf(oldItem);
                        items.add(indexOldItem + 1, newItem);
                    }
                    break;
                case "Renew":
                    String renewItem = commands[1];
                    if (items.contains(renewItem)) {
                        items.remove(renewItem);
                        items.add(items.size(), renewItem);

                    }
                    break;
            }

            inputLine = scanner.nextLine();
        }
            System.out.print(String.join(", ", items));
    }
}