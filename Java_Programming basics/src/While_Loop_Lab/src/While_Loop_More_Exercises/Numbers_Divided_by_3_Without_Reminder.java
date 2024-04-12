package While_Loop_More_Exercises;

import java.util.Scanner;

public class Numbers_Divided_by_3_Without_Reminder {
    public static void main(String[] args) {


        int num = 1;

        while (num != 100){
            num++;
            if (num % 3 == 0){
                System.out.println(num);
            }
        }
    }
}
