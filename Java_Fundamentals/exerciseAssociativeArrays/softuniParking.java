package exerciseAssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class softuniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            if (command.split("\\s+")[0].equals("register")) {
                String username = command.split("\\s+")[1];
                String licensePlate = command.split("\\s+")[2];

                if (!map.containsKey(username)) {
                    map.put(username, licensePlate);

                        System.out.printf("%s registered %s successfully%n",username, licensePlate);

                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", map.get(username));

                }
            } else if (command.split("\\s+")[0].equals("unregister")) {
                String username = command.split("\\s+")[1];
                if (!map.containsKey(username)){
                    System.out.printf("ERROR: user %s not found%n", username);
                }else {
                    System.out.printf("%s unregistered successfully%n", username);
                    map.remove(username);
                }
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }

    }
}
