package dataTypesAndVariablesLab;

import java.util.Scanner;

public class townInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Town {town name} has population of {population} and area {area} square km.
        String townName = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        short area = Short.parseShort(scanner.nextLine());

        String result = String.format
                ("Town %s has population of %d and area %d square km.", townName, population, area);

        System.out.println(result);
    }
}
