package JavaAdvanced.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _1_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Predicate<Integer> isEven = num -> num % 2 == 0;

        List<Integer> evenIntegers = Arrays.stream(scan.nextLine().split(",\\s+"))
                .map(Integer::parseInt).filter(isEven)
                .collect(Collectors.toList());

        System.out.println(evenIntegers.stream().map(Object::toString).collect(Collectors.joining(", ")));
        Collections.sort(evenIntegers);
        System.out.println(evenIntegers.stream().map(Object::toString).collect(Collectors.joining(", ")));

    }
}
