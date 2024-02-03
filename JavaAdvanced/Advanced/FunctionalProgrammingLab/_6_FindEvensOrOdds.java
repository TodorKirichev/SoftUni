package JavaAdvanced.FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.lang.System.in;

public class _6_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int down = scan.nextInt();
        int up = scan.nextInt();
        scan.nextLine();

        List<Integer> numbers = new ArrayList<>();
        String type = scan.nextLine();

        IntStream.rangeClosed(down,up).forEach(numbers::add);
        Predicate<Integer> isEven = getNum(type);

        numbers.stream().filter(isEven).forEach(n -> System.out.printf("%d ",n));
    }
    private static Predicate<Integer> getNum(String type) {
        if (type.equals("even")) {
            return n -> n % 2 == 0;
        } else {
            return n -> n % 2 != 0;
        }
    }
}
