package SoftUni.JavaAdvanced.OOP.ReflectionExercises._1_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class<?> clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();

        String command = scan.nextLine();

        while (!"HARVEST".equals(command)) {
            printFields(fields, command);
            command = scan.nextLine();
        }
    }

    private static void printFields(Field[] fields, String command) {
        Arrays.stream(fields)
                .filter(field -> {
                    switch (command) {
                        case "private":
                            return Modifier.isPrivate(field.getModifiers());
                        case "protected":
                            return Modifier.isProtected(field.getModifiers());
                        case "public":
                            return Modifier.isPublic(field.getModifiers());
                        default:
                            return true;
                    }
                })
                .forEach(field -> System.out.printf("%s %s %s\n",
                        Modifier.toString(field.getModifiers()),
                        field.getType().getSimpleName(),
                        field.getName()));
    }
}
