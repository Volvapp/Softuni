package exerciseRegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String participants = scanner.nextLine();
        String input = scanner.nextLine();

        List<String> names = Arrays.stream(participants.split(", ")).collect(Collectors.toList());
        Map<String, Integer> racerDistance = new LinkedHashMap<>();
        names.forEach(name -> racerDistance.put(name, 0));

        String regexLetters = "[A-Za-z]+";
        Pattern patternLetters = Pattern.compile(regexLetters);
        String regexDigits = "[0-9]";
        Pattern patternDigits = Pattern.compile(regexDigits);


        while (!input.equals("end of race")) {
            StringBuilder name = new StringBuilder();
            Matcher matcherLetters = patternLetters.matcher(input);
            Matcher matcherDigits = patternDigits.matcher(input);

            while (matcherLetters.find()) {
                name.append(matcherLetters.group());
            }

            int distance = 0;
            while (matcherDigits.find()) {
                distance += Integer.parseInt(matcherDigits.group());
            }
            if (names.contains(name.toString())) {
                int currentDistance = racerDistance.get(name.toString());
                racerDistance.put(name.toString(), currentDistance + distance);
            }

            input = scanner.nextLine();
        }
        //sort ascending order ->
        //racerDistance.entrySet().stream().sorted(Map.Entry.comparingByValue());
        //sort descending order ->
        List<String> top3Names = racerDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println("1st place: " + top3Names.get(0));
        System.out.println("2nd place: " + top3Names.get(1));
        System.out.println("3rd place: " + top3Names.get(2));


        /*int counter = 1;

        for (Map.Entry<String, Integer> pair : racerDistance.entrySet()) {
            if (counter == 1) {
                System.out.println("1st place: " + pair.getKey());
                counter++;
            } else if (counter == 2) {
                System.out.println("2nd place: " + pair.getKey());
                counter++;
            }else if (counter == 3){
                System.out.println("3rd place: " + pair.getKey());
                break;
            }
       }*/
    }
}
