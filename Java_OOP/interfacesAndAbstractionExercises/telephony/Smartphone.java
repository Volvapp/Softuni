package interfacesAndAbstractionExercises.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            boolean isDigit = false;
            for (int i = 0; i < url.length(); i++) {
                if (Character.isDigit(url.charAt(i))) {
                    sb.append("Invalid URL!").append(System.lineSeparator());
                    isDigit = true;
                    break;
                }
            }
            if (!isDigit) {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            boolean isLetter = false;
            for (int i = 0; i < number.length(); i++) {
                if (Character.isAlphabetic(number.charAt(i))) {
                    sb.append("Invalid number!").append(System.lineSeparator());
                    isLetter = true;
                    break;
                }
            }
            if (!isLetter) {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
