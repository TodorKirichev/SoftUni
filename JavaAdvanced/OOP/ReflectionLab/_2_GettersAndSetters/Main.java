package SoftUni.JavaAdvanced.OOP.ReflectionLab._2_GettersAndSetters;

import SoftUni.JavaAdvanced.OOP.ReflectionLab.Reflection;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods).filter(method -> method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method ->  System.out.printf("%s will return class %s%n",
                        method.getName(),
                        method.getReturnType().getName()));
        Arrays.stream(methods).filter(method -> method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method ->  System.out.printf("%s and will set field of class %s%n",
                        method.getName(),
                        method.getParameters()[0].getType().getName()));
    }
}
