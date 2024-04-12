package labReflectionAndAnnotations.highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> reflectionClass = Reflection.class;

        Field[] fields = reflectionClass.getDeclaredFields();
        Method[] methods = reflectionClass.getDeclaredMethods();

        Arrays.stream(fields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!%n", field.getName()));

        Arrays.stream(methods)
                .filter(Main::isGetterMethod)
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!%n", method.getName()));

        Arrays.stream(methods)
                .filter(Main::isSetterMethod)
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!%n", method.getName() ));
    }
    private static boolean isGetterMethod(Method m) {
        if (!m.getName().startsWith("get")) {
            return false;
        }
        if (m.getParameterCount() > 0) {
            return false;
        }
        if (m.getReturnType().equals(void.class)) {
            return false;
        }
        return true;
    }
    private static boolean isSetterMethod(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterCount() != 1) {
            return false;
        }
        if (!method.getReturnType().equals(void.class)) {
            return false;
        }
        return true;
    }
}
