package LabEncapsulation.SortByNameAndAge;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            Person personToAdd = new Person(firstName, lastName, age);
            people.add(personToAdd);
        }

        Collections.sort(people, Comparator.comparing(Person::getFirstName).thenComparingInt(Person::getAge));


//        Collections.sort(people, (firstPerson, secondPerson) -> {
//            int result = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
//
//            if (result == 0){
//                result = Integer.compare(firstPerson.getAge(), secondPerson.getAge());
//            }
//            return result;
//        });

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
