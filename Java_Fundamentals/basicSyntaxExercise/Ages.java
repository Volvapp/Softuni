package basicSyntaxExercise;

import java.util.Scanner;

public class Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	0-2 – baby;
        //•	3-13 – child;
        //•	14-19 – teenager;
        //•	20-65 – adult;
        //•	>=66 – elder;
        int age = Integer.parseInt(scanner.nextLine());

        if (age <= 2 && age >= 0) {
            System.out.println("baby");
        }else if (age <=13){
            System.out.println("child");
        }else if (age <= 19){
            System.out.println("teenager");
        }else if (age <= 65){
            System.out.println("adult");
        }else {
            System.out.println("elder");
        }
    }
}

