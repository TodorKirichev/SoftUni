package ObjectsAndClassesExercise.OrderByAge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("End")) {
                break;
            }
            String[] personData = input.split(" ");
            String name = personData[0];
            String ID = personData[1];
            int age = Integer.parseInt(personData[2]);

            Person person = new Person(name,ID,age);
            persons.add(person);
        }
        Collections.sort(persons, Comparator.comparingInt(Person::getAge));
        for (Person person : persons) {
            System.out.printf("%s with ID: %s is %d years old.%n",person.getName(),person.getID(),person.getAge());
        }
    }
}
