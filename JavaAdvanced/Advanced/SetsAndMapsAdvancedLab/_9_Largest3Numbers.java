package JavaAdvanced.SetsAndMapsAdvancedLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _9_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1,n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        print(numbers);
    }

    private static void print(List<Integer> numbers) {
        if (numbers.size() < 3) {
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(numbers.get(i) + " ");
            }
        }
    }
}
