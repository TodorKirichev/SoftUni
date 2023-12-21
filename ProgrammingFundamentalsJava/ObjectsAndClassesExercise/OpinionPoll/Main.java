package ObjectsAndClassesExercise.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] input = scan.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            if (age > 30) {
                Person person = new Person(name,age);
                persons.add(person);
            }
        }
        for (Person person : persons) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
