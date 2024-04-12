package exerciseAssociativeArrays;

import java.util.*;

public class companyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String companyName = command.split(" -> ")[0];
            String id = command.split(" -> ")[1];

            if (!map.containsKey(companyName)) {
                map.put(companyName, new ArrayList<>());
            }if (map.get(companyName).contains(id)){
                command = scanner.nextLine();
                continue;
            }
            map.get(companyName).add(id);

            command = scanner.nextLine();
        }
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            entry.getValue().forEach(id -> System.out.println("-- " + id));
        });
    }
}
