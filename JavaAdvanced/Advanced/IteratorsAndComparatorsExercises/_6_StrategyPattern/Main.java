package Exams.IteratorsAndComparatorsExercises._6_StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        TreeSet<Person> compByName = new TreeSet<>(new Person.ComparatorByName());
        TreeSet<Person> compByAge = new TreeSet<>(new Person.ComparatorByAge());


        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String name = line[0];
            int age = Integer.parseInt(line[1]);

            Person person = new Person(name,age);
            compByName.add(person);
            compByAge.add(person);
        }
        compByName.forEach(p -> System.out.printf("%s %d\n",p.getName(),p.getAge()));
        compByAge.forEach(p -> System.out.printf("%s %d\n",p.getName(),p.getAge()));
    }
}
