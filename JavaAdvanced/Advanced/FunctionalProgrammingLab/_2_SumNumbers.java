package JavaAdvanced.FunctionalProgrammingLab;

import java.util.Scanner;
import java.util.function.Function;

import static java.lang.System.in;

public class _2_SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] numbers = scan.nextLine().split(",\\s+");
        Function<String,Integer> convertToInt = Integer::parseInt;

        int sum = 0;
        for (String number : numbers) {
            sum += convertToInt.apply(number);
        }
        System.out.printf("Count = %d\n",numbers.length);
        System.out.printf("Sum = %d\n",sum);
    }
}
