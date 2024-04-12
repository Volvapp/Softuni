import java.util.Scanner;

public class Vacation_Books_List_E4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pages = Integer.parseInt(scanner.nextLine());

        int pagesPerHour = Integer.parseInt(scanner.nextLine());

        int daysNeeded = Integer.parseInt(scanner.nextLine());

        int totalHours = pages / pagesPerHour;

        int hoursPerDay = totalHours / daysNeeded;

        System.out.println(hoursPerDay);



    }
}
