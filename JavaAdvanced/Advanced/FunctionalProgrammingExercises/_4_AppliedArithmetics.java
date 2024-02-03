package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _4_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = integers -> integers.stream().map(i -> i + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = integers -> integers.stream().map(i -> i * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = integers -> integers.stream().map(i -> i - 1).collect(Collectors.toList());
        Consumer<List<Integer>> print = integers -> integers.forEach(i -> System.out.printf("%d ",i));

        while (true) {
            String command = scan.nextLine();
            if (command.equals("end")) {
                break;
            }
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
        }
    }
}
