package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.lang.System.in;

public class _9_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int range = Integer.parseInt(scan.nextLine());

        int[] dividers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Predicate<Integer> isDivisible = integer -> {
            for (int divider : dividers) {
                if (integer % divider != 0) {
                    return false;
                }
            }
            return true;
        };
        IntStream.rangeClosed(1,range).filter(isDivisible::test).forEach(i -> System.out.printf("%d ",i));
    }
}
