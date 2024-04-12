package exerciseDataTypesAndVariables;

import java.util.Scanner;

public class beerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countKegs = Integer.parseInt(scanner.nextLine());
        //π * r^2 * h
        double maxVolume = Double.MIN_VALUE;
        String maxVolumeKeg = null;
        for (int i = 1; i <= countKegs; i++) {
            String modelKeg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (volume > maxVolume){
                maxVolume = volume;
                maxVolumeKeg = modelKeg;
            }
        }
        System.out.println(maxVolumeKeg);
    }
}
