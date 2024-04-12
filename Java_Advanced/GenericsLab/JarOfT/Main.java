package GenericsLab.JarOfT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jar<Integer> jar = new Jar<>();

        jar.add(23);
        System.out.println(jar.remove());
    }
}
