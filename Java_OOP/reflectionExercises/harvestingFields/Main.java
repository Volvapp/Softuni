package reflectionExercises.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<Field>> fieldsMap = getFieldsMap();

        while (!input.equals("HARVEST")) {

            fieldsMap.get(input).forEach(field -> System.out.printf("%s %s %s%n",
                    Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));


            input = scanner.nextLine();
        }
    }

    private static Map<String, List<Field>> getFieldsMap() {
        Map<String, List<Field>> fieldsMap = new HashMap<>();
        fieldsMap.put("private", new ArrayList<>());
        fieldsMap.put("protected", new ArrayList<>());
        fieldsMap.put("public", new ArrayList<>());

        List<Field> allFields = Arrays.asList(RichSoilLand.class.getDeclaredFields());

        fieldsMap.put("all", allFields);

        allFields.forEach(field -> fieldsMap.get(Modifier.toString(field.getModifiers())).add(field));
        return fieldsMap;
    }
}
