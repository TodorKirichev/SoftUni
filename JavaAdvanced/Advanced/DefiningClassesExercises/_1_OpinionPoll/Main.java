package JavaAdvanced.DefiningClassesExercises._1_OpinionPoll;

import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int n = Integer.parseInt(scan.nextLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name,age);
            persons.add(person);
        }
        persons.stream().filter(p -> p.getAge() > 30).sorted((f,s) -> f.getName().compareTo(s.getName())).forEach(System.out::println);
    }
}
