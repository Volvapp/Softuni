public class factorial {
    public static void main(String[] args) {

        long fact;
        int number = 5;
        fact = fact(number);
        System.out.println("Factorial of " + number + " is: " + fact);
    }

    private static long fact(int n) {
        if (n == 0) {
            return 1;
        } else {

            return (n * fact(n - 1));
        }
    }

}