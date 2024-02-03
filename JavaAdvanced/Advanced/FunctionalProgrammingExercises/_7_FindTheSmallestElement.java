package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _7_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>,Integer> indexOfSmallest = integers -> {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) <= min) {
                    min = numbers.get(i);
                    index = i;
                }
            }
            return index;
        };
        System.out.println(indexOfSmallest.apply(numbers));
    }
}
