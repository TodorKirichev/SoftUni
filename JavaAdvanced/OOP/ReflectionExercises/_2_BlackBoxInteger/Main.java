package SoftUni.JavaAdvanced.OOP.ReflectionExercises._2_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        String command = scan.nextLine();

        while (!"END".equals(command)) {

            String methodName = command.split("_")[0];
            int value = Integer.parseInt(command.split("_")[1]);

            List<Method> methods = List.of(clazz.getDeclaredMethods());
            Method method = methods.stream().filter(method1 -> method1.getName().equals(methodName)).findFirst().get();
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            Field field = clazz.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));

            command = scan.nextLine();
        }
    }
}
