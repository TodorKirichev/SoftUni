package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _2_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        Consumer<String> print = name -> System.out.printf("Sir %s\n",name);

        names.forEach(print);
    }
}
