package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (numbers.size() % 2 == 0) {
            for (int i = 0; i < numbers.size(); i++) {
                int left = numbers.get(i);
                int right = numbers.get(numbers.size() - 1);
                numbers.set(i,left + right);
                numbers.remove(numbers.size() - 1);
            }
        } else {
            for (int i = 0; i < numbers.size() - 1; i++) {
                int left = numbers.get(i);
                int right = numbers.get(numbers.size() - 1);
                numbers.set(i,left + right);
                numbers.remove(numbers.size() - 1);
            }
        }
        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}
