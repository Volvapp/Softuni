package For_Loop_Exercise;

import java.util.Scanner;

public class Trekking_Mania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());

        int allPeople = 0;
        int musalaPeople = 0;
        int montblanPeople = 0;
        int kilimandjaroPeople = 0;
        int k2People = 0;
        int everestPeople = 0;
        for (int i = 1; i <= groups; i++) {
            int peopleInGroups = Integer.parseInt(scanner.nextLine());

            allPeople = allPeople + peopleInGroups;

            if (peopleInGroups <= 5){
                musalaPeople = musalaPeople + peopleInGroups;
            }else if (peopleInGroups <= 12){
                montblanPeople = montblanPeople + peopleInGroups;
            }else if (peopleInGroups <= 25){
                kilimandjaroPeople = kilimandjaroPeople + peopleInGroups;
            }else if (peopleInGroups <= 40){
                k2People = k2People + peopleInGroups;
            }else {
                everestPeople = everestPeople + peopleInGroups;
            }
        }
        System.out.printf("%.2f%%%n",musalaPeople * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n",montblanPeople * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n",kilimandjaroPeople * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n",k2People * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n",everestPeople * 1.0 / allPeople * 100);
    }
}
