package JavaAdvanced.FunctionalProgrammingExercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;
import static java.lang.System.nanoTime;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<String> peoples = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Set<String> filters = new HashSet<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Print")) {
                break;
            }
            String[] inputData = input.split(";");
            String command = inputData[0];
            String filter = inputData[1];
            String parameter = inputData[2];

            if (command.equals("Add filter")) {
                filters.add(filter + ":" + parameter);
            } else if (command.equals("Remove filter")) {
                filters.remove(filter + ":" + parameter);
            }
        }

        for (String filter : filters) {
            Predicate<String> predicate = getPredicate(filter);
            peoples.removeIf(predicate);
        }
        peoples.forEach(name -> System.out.print(name + " "));
    }

    private static Predicate<String> getPredicate(String filter) {

        String filterName = filter.split(":")[0];
        String parameter = filter.split(":")[1];

        switch (filterName) {
            case "Starts with":
                return name -> name.startsWith(parameter);
            case "Ends with":
                return name -> name.endsWith(parameter);
            case "Length":
                return name -> name.length() == Integer.parseInt(parameter);
            case "Contains":
                return name -> name.contains(parameter);
        }

        throw new IllegalArgumentException("Unknown");
    }
}
