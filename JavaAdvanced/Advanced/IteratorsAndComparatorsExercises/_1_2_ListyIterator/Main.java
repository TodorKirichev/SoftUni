package Exams.IteratorsAndComparatorsExercises._1_2_ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        ListyIterator listyIterator = new ListyIterator();

        while (true) {
            String[] line = scan.nextLine().split("\\s+");
            String command = line[0];
            if (command.equals("END")) {
                break;
            }
            switch (command) {
                case "Create":
                    String[] data = Arrays.copyOfRange(line,1,line.length);
                    listyIterator = new ListyIterator(data);
                    break;
                case "Move":
                    System.out.println(listyIterator.Move());
                    break;
                case "Print":
                    listyIterator.Print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.PrintAll();
                    break;
            }
        }
    }
}
