package JavaAdvanced.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class _3_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Predicate<String> isUpper = word -> Character.isUpperCase(word.charAt(0));

        List<String> upperCaseWords = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(isUpper).collect(Collectors.toList());

        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(System.out::println);
    }
}
