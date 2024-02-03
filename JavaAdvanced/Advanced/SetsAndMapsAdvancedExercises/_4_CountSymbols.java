package JavaAdvanced.SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Character,Integer> appearances = new TreeMap<>();

        String input = scan.nextLine();

        for (char c : input.toCharArray()) {
            if (appearances.containsKey(c)) {
                appearances.put(c,appearances.get(c) + 1);
            } else {
                appearances.put(c,1);
            }
        }
        appearances.forEach((key,value) -> {
            System.out.printf("%s: %d time/s\n",key,value);
        });
    }
}
