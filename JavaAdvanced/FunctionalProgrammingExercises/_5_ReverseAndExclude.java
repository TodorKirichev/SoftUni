package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _5_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divider = Integer.parseInt(scan.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> isDivisible = i -> i % divider != 0;

        numbers.stream().filter(isDivisible).forEach(i -> System.out.printf("%d ",i));
    }
}
