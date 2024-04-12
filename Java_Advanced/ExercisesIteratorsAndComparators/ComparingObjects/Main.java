package ExercisesIteratorsAndComparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        List<Person> peopleList = new ArrayList<>();

        while (!input.equals("END")) {

            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            String town = input.split("\\s+")[2];

            Person person = new Person(name, age, town);
            peopleList.add(person);

            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        Person chosenPerson = peopleList.get(n - 1);
        peopleList.remove(n - 1);


        int countEqualPeople = 0;
        int countDiffPeople = 0;
        for (Person person : peopleList) {
            if (chosenPerson.compareTo(person) == 0) {
                countEqualPeople++;
            } else {
                countDiffPeople++;
            }
        }
        if (countEqualPeople > 0) {
            System.out.println((countEqualPeople + 1) + " " + countDiffPeople + " " + (peopleList.size() + 1));
        } else {
            System.out.println("No matches");
        }
    }
}
