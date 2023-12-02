package ListsLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);

            if (number < 0) {
                numbers.remove(i);
                i--;
            }
        }
        Collections.reverse(numbers);
        if (numbers.size() == 0) {
            System.out.println("empty");
        } else {
            for (int i : numbers) {
                System.out.printf("%d ",i);
            }
        }
    }
}
