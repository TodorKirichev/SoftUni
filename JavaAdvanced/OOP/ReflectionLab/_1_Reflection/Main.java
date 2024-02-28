package SoftUni.JavaAdvanced.OOP.ReflectionLab._1_Reflection;

import SoftUni.JavaAdvanced.OOP.ReflectionLab.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scan = new Scanner(System.in);

        Class clazz = Reflection.class;
        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Arrays.stream(clazz.getInterfaces()).forEach(System.out::println);
        System.out.println(clazz.getConstructor().newInstance());

    }
}
