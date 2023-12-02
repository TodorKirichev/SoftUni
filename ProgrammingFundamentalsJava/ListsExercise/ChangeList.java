package ListsExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                       .map(Integer::parseInt)
                       .collect(Collectors.toList());
       String command = scan.nextLine();

       while (!command.equals("end")){
           int element = Integer.parseInt(command.split(" ")[1]);

           if (command.contains("Delete")){
               numbers.removeAll(Collections.singleton(element));
           } else if (command.contains("Insert")) {
               int index = Integer.parseInt(command.split(" ")[2]);
               numbers.add(index,element);
           }

           command = scan.nextLine();
       }
        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}
