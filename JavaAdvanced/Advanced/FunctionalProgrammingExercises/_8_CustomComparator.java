package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.in;

public class _8_CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Integer[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (f,s) -> {
            if (f % 2 == 0 && s % 2 != 0) {
                return -1;
            } else if (s % 2 == 0 && f % 2 != 0) {
                return 1;
            }
            return f.compareTo(s);
        };
        Arrays.sort(numbers,comparator);
        Arrays.stream(numbers).forEach(i -> System.out.printf("%d ",i));
    }
}
