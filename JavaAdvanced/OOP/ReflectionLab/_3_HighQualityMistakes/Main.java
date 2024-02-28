package SoftUni.JavaAdvanced.OOP.ReflectionLab._3_HighQualityMistakes;

import SoftUni.JavaAdvanced.OOP.ReflectionLab.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class clazz = Reflection.class;

        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(fields).filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.printf("%s must be private!\n",field.getName()));
        Arrays.stream(methods).filter(method -> method.getName().startsWith("get") && !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be public!\n",method.getName()));
        Arrays.stream(methods).filter(method -> method.getName().startsWith("set") && !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s have to be private!\n",method.getName()));
    }
}
