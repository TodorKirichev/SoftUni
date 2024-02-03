package JavaAdvanced.SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _4_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double,Integer> numbersCounts = new LinkedHashMap<>();

        for (double number : numbers) {
            if (numbersCounts.containsKey(number)) {
                numbersCounts.put(number,numbersCounts.get(number) + 1);
            } else {
                numbersCounts.put(number,1);
            }
        }
        print(numbersCounts);
    }

    private static void print(Map<Double, Integer> numbersCounts) {
        numbersCounts.forEach((key, value) -> {
            System.out.printf("%.1f -> %d\n",key,value);
        });
    }
}
