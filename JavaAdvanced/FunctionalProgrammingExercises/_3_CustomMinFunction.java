package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.in;

public class _3_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[],Integer> smallest = integers -> Arrays.stream(integers).mapToInt(n -> n).min().orElse(0);
        System.out.println(smallest.apply(numbers));
    }
}
