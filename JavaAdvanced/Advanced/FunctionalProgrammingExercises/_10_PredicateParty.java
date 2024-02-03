package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _10_PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<String> peoples = Arrays.stream(scan.nextLine().split("\\s")).collect(Collectors.toList());

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Party!")) {
                break;
            }
            String[] inputData = input.split("\\s+");
            String operation = inputData[0];
            String criteria = inputData[1];
            String element = inputData[2];

            Predicate<String> predicate = getPredicate(criteria, element);

            switch (operation) {
                case "Double":
                    List<String> listToAdd = peoples.stream().filter(predicate).collect(Collectors.toList());
                    peoples.addAll(listToAdd);
                    break;
                case "Remove":
                    List<String> listToRemove = peoples.stream().filter(predicate).collect(Collectors.toList());
                    peoples.removeAll(listToRemove);
                    break;
            }

        }
        if (peoples.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(peoples);
            System.out.printf("%s are going to the party!\n",String.join(", ",peoples));
        }

    }

    private static Predicate<String> getPredicate(String criteria, String element) {
        switch (criteria) {
            case "StartsWith":
                return name -> name.startsWith(element);
            case "EndsWith":
                return name -> name.endsWith(element);
            case "Length":
                return name -> name.length() == Integer.parseInt(element);
            default:
                throw new IllegalArgumentException("Unknown condition");
        }
    }
}
