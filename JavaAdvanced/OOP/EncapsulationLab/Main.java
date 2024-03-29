package SoftUni.JavaAdvanced.OOP.EncapsulationLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);
            Person person = null;
            try {
                person = new Person(firstName, lastName, age, salary);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            if (person != null) {
                people.add(person);
            }
        }
        Team team = new Team("Black eagles");
        for (Person person : people) {
            team.addPlayer(person);
        }
        System.out.printf("First team have %d players\n",team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players\n",team.getReserveTeam().size());
    }
}
