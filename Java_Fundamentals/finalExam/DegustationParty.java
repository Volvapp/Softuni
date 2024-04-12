package finalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> guestAndLiked = new LinkedHashMap<>();
        int dislikedMealsCounter = 0;
        while (!input.equals("Stop")) {

            String[] commands = input.split("-");
            String guest = commands[1];
            String meal = commands[2];
            switch (commands[0]) {
                case "Like":
                    if (guestAndLiked.containsKey(guest)) {
                        if (guestAndLiked.containsValue(meal)) {
                            break;
                        } else {
                            guestAndLiked.put(guest, guestAndLiked.get(guest) + ", " + meal);
                        }
                    } else {
                        guestAndLiked.put(guest, meal);
                    }
                    break;
                case "Dislike":
                    if (!guestAndLiked.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else if (!guestAndLiked.containsValue(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                    } else {
                        guestAndLiked.replace(guest, "");
                        dislikedMealsCounter++;
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : guestAndLiked.entrySet()) {
            System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Unliked meals: " + dislikedMealsCounter);
    }
}
