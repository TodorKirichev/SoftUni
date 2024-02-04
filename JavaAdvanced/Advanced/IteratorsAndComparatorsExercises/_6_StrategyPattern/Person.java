package Exams.IteratorsAndComparatorsExercises._6_StrategyPattern;

import java.util.Comparator;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    public static class ComparatorByName implements Comparator<Person> {

       @Override
       public int compare(Person first, Person second) {
           if (Integer.compare(first.getName().length(),(second.getName().length())) == 0) {
               return Integer.compare(first.getName().toLowerCase().charAt(0),second.getName().toLowerCase().charAt(0));
           } else {
               return Integer.compare(first.getName().length(),(second.getName().length()));
           }
       }
   }
    public static class ComparatorByAge implements Comparator<Person> {

        @Override
        public int compare(Person first, Person second) {
            return Integer.compare(first.getAge(),second.getAge());
        }
    }
}
