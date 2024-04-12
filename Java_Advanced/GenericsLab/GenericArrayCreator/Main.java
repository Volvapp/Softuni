package GenericsLab.GenericArrayCreator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> smd = ArrayCreator.create(10, 5);

        System.out.println(smd);

    }
}
