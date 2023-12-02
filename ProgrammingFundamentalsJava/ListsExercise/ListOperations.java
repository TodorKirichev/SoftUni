package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("End")){
            String [] input = command.split(" ");
            String commandName = input[0];

            if (commandName.equals("Add")){
                int number = Integer.parseInt(input[1]);
                numbers.add(number);
            } else if (commandName.equals("Insert")) {
                int number = Integer.parseInt(input[1]);
                int index = Integer.parseInt(input[2]);
               if (index >= 0 && index < numbers.size()){
                   numbers.add(index,number);
               } else {
                   System.out.println("Invalid index");
               }
            } else if (commandName.equals("Remove")) {
                int index = Integer.parseInt(input[1]);
              if (index >= 0 && index < numbers.size()){
                  numbers.remove(index);
              } else {
                  System.out.println("Invalid index");
              }
            } else if (input[1].equals("left")) {
                int count = Integer.parseInt(input[2]);
                for (int i = 0; i < count; i++) {
                    int first = numbers.get(0);
                    numbers.add(first);
                    numbers.remove(0);

                }
            } else if (input[1].equals("right")) {
                int count = Integer.parseInt(input[2]);
                for (int i = 0; i < count; i++) {
                    int last = numbers.get(numbers.size() - 1);
                    numbers.add(0,last);
                    numbers.remove(numbers.size() - 1);
                }
            }

            command = scan.nextLine();
        }
        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}
