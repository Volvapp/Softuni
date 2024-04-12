package finalExamPrep;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "([#|\\|])(?<item>[A-Za-z\\s]+)\\1(?<expDate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]+)\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int neededCalories = 2000;
        int allCalories = 0;

        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            String currentItem = matcher.group("item");
            String currentDate = matcher.group("expDate");
            int currentCalories = Integer.parseInt(matcher.group("calories"));
            allCalories += currentCalories;
            words.add("Item: " + currentItem + ", Best before: " + currentDate + ", Nutrition: " + currentCalories);
        }
        System.out.printf("You have food to last you for: %d days!%n", allCalories / neededCalories);
        if (allCalories / neededCalories >= 1) {
            for (String word : words) {
                System.out.println(word);
            }
        }

    }
}