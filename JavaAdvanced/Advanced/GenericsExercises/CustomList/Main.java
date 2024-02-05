package SoftUni.JavaAdvanced.Advanced.GenericsExercises.CustomList;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        CustomList<String> list = new CustomList<>();

        while (true) {
            String command = scan.nextLine();
            if (command.equals("END")) {
                break;
            }
            String[] commandParts = command.split("\\s+");

            switch (commandParts[0]) {
                case "Add":
                    list.add(commandParts[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(commandParts[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(commandParts[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(commandParts[1]),Integer.parseInt(commandParts[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreater(commandParts[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }
        }
    }
}
