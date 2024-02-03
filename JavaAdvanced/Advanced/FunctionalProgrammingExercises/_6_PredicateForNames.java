package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

import static java.lang.System.in;

public class _6_PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int length = Integer.parseInt(scan.nextLine());

        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> checkLength = name -> name.length() <= length;

        Arrays.stream(names).filter(checkLength).forEach(System.out::println);
    }
}
