package Exams.IteratorsAndComparatorsExercises._3_StackIterator;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        StackIterator stackIterator = new StackIterator();

        while (true) {
            String[] line = scan.nextLine().split("\\s+");
            String command = line[0];
            if (command.equals("END")) {
                break;
            }
            switch (command) {
                case "Push":
                    String[] elements = Arrays.copyOfRange(line,1,line.length);
                    Arrays.stream(elements).forEach(e -> stackIterator.push(Integer.parseInt(String.valueOf(e.charAt(0)))));
                    break;
                case "Pop":
                    try {
                        stackIterator.pop();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        stackIterator.forEach(System.out::println);
        stackIterator.forEach(System.out::println);
    }
}
