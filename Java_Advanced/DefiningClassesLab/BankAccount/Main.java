package DefiningClassesLab.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        accounts = new HashMap<>();

        while (!input.equals("End")) {

            String[] parts = input.split("\\s+");
            String command = parts[0];

            String result = "";

            switch (command) {

                case "Create":
                    result = createAccount();
                    break;
                case "Deposit":
                    result = depositInAccount(parts);
                    break;
                case "SetInterest":
                    result = setInterest(parts);
                    break;
                case "GetInterest":
                    result = getInterest(parts);
                    break;
            }

            if (!result.isEmpty()) {
                System.out.println(result);
            }

            input = scanner.nextLine();
        }
    }
    private static String getInterest(String[] inputParts){
        int id = Integer.parseInt(inputParts[1]);
        int years = Integer.parseInt(inputParts[2]);

        BankAccount bankAccount = accounts.get(id);

        if (bankAccount == null){
            return "Account does not exist";

        }
        double interest = bankAccount.getInterest(years);
        return String.format("%.2f", interest);
    }

    private static String setInterest(String[] inputParts){
        double interest = Double.parseDouble(inputParts[1]);

        BankAccount.setInterestRate(interest);

        return "";
    }

    private static String depositInAccount(String[] parts) {
        int accountId = Integer.parseInt(parts[1]);
        double amount = Double.parseDouble(parts[2]);

        if (!accounts.containsKey(accountId)) {
            return "Account does not exist";
        }
        accounts.get(accountId).deposit(amount);

        return String.format("Deposited %.0f to ID%d", amount, accountId);
    }

    private static String createAccount() {
        BankAccount bankAccount = new BankAccount();
        int id = bankAccount.getId();

        accounts.put(id, bankAccount);

        return String.format("Account ID%d created", id);
    }
}
