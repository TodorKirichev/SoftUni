package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scan.next();

        while (!command.equals("end")) {

            int n = Integer.parseInt(scan.next());

            if (command.equals("Add")) {
                numbers.add(n);
            } else if (command.equals("Remove")) {
                numbers.remove(Integer.valueOf(n));
            } else if (command.equals("RemoveAt")) {
                numbers.remove(numbers.get(n));
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(scan.next());
                numbers.add(index,n);
            }

            command = scan.next();
        }
        for (int i : numbers) {
            System.out.printf("%d ",i);
        }
    }
}
