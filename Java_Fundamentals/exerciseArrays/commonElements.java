package exerciseArrays;

import java.util.Scanner;

public class commonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArray = scanner.nextLine().split(" ");

        for (String elementSecondArray : secondArray){

            for (String elementFirstArray : firstArray) {

                if (elementSecondArray.equals(elementFirstArray)){
                    System.out.printf("%s ", elementSecondArray);
                    break;
                }
            }
        }
    }
}
