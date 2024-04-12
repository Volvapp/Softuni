public class demo {
    public static void main(String[] args) {

        int symbols = 1;
        int spaces = 3;

        for (int i = 0; i < 3; i++) {

            for (int k = spaces; k > 0; k--) {

                System.out.print(" ");
            }
            spaces--;

            System.out.print("(");

            for (int j = 0; j < symbols; j++) {


                if (j < symbols - 1) {
                    System.out.print("* ");
                    
                } else {
                    System.out.print("*");
                }
            }

            symbols++;

            System.out.print(")\n");
        }
    }
}
