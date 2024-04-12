public class Multiplication_Table {
    public static void main(String[] args) {

        for (int i1 = 1; i1 <= 10; i1++) {
            for (int i2 = 1; i2 <= 10; i2++) {
                int product = i1 * i2;
                System.out.println(i1 + " * " + i2 + " = " + product);
            }
        }
    }
}
