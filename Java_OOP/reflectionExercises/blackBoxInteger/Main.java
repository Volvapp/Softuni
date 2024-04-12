package reflectionExercises.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        String[] commands = scanner.nextLine().split("_");

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        List<Method> methods = Arrays.asList(blackBoxIntClass.getDeclaredMethods());

        Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");

        while (!commands[0].equals("END")) {
            int value = Integer.parseInt(commands[1]);

            if (((commands[0].equals("add") || commands[0].equals("subtract") ||
                    commands[0].equals("divide")) || commands[0].equals("multiply")) ||
                    commands[0].equals("rightShift") || commands[0].equals("leftShift")) {
                executeCommand(blackBoxInt, innerValue, value, commands[0], methods);
            }

            commands = scanner.nextLine().split("_");
        }
    }

    private static void executeCommand(BlackBoxInt blackBoxInt,
                                       Field innerValue, int value, String command, List<Method> methods)
            throws IllegalAccessException, InvocationTargetException {


        Method currentMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(command)){
                currentMethod = method;
                break;
            }
        }
        currentMethod.setAccessible(true);
        currentMethod.invoke(blackBoxInt, value);
        innerValue.setAccessible(true);
        System.out.println(innerValue.get(blackBoxInt));
    }
}
