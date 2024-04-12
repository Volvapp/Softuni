import java.util.Scanner;

public class Project_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String arc = String.valueOf(scan.nextLine()); //"George";
        int projects = Integer.parseInt(scan.nextLine());
        int hours = projects * 3;
        System.out.println("The architect " + arc + " will need " + hours + " hours to complete " + projects + " project/s.");
    }
}
