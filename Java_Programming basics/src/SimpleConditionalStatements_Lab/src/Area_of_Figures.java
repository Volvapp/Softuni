import java.util.Scanner;

public class Area_of_Figures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeOfFigure = scanner.nextLine();

        if (typeOfFigure.equals("square")){
            double side = Double.parseDouble(scanner.nextLine());
            double S = side * side;
            System.out.printf("%.3f", S);
        }
        else if (typeOfFigure.equals("rectangle")){
            double side1 = Double.parseDouble(scanner.nextLine());
            double side2 = Double.parseDouble(scanner.nextLine());
            double S = side1 * side2;
            System.out.printf("%.3f", S);
        }
        else if (typeOfFigure.equals("circle")){
            double radius = Double.parseDouble(scanner.nextLine());
            double S = radius * radius * Math.PI;
            System.out.printf("%.3f", S);
        }
        else if (typeOfFigure.equals("triangle")){
            double side = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            double S = side * height / 2;
            System.out.printf("%.3f", S);
            }
        }
    }

