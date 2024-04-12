package finalExamPrep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;

        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                StringBuilder numbers = new StringBuilder();
                for (int j = 0; j < barcode.length(); j++) {
                    char currentSymbol = barcode.charAt(j);
                    if (Character.isDigit(currentSymbol)) {
                        numbers.append(currentSymbol);
                    } else {

                    }
                }
                if (numbers.length() == 0) {
                    System.out.printf("Product group: 00%n");
                } else {
                    System.out.printf("Product group: %s%n", numbers);
                }
                    } else{
                        System.out.println("Invalid barcode");
                    }
                }
            }
        }
