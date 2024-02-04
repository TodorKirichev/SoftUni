package Exams.IteratorsAndComparatorsExercises._5_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<Person> list = new ArrayList<>();

        while (true) {
            String line = scan.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] info = line.split("\\s+");
            Person person = new Person(info[0],Integer.parseInt(info[1]),info[2]);
            list.add(person);
        }
        int n = Integer.parseInt(scan.nextLine());
        Person person = list.get(n - 1);
        list.remove(person);
        int equal = 0;
        int notEqual = 0;
        for (Person p : list) {
            if (p.equals(person)) {
                equal++;
            } else {
                notEqual++;
            }
        }
        if (list.size() < 2) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d\n",equal + 1,notEqual,list.size() + 1);
        }
    }
}
