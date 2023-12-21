package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        Map <Character,Integer> countChars = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            if (symbol != ' ') {
                if (!countChars.containsKey(symbol)) {
                    countChars.put(symbol,1);
                } else {
                    countChars.put(symbol, countChars.get(symbol) + 1);
                }
            }
        }
        countChars.entrySet().forEach(entry -> System.out.printf("%c -> %d\n",entry.getKey(),entry.getValue()));
        // countChars.forEach((key, value) -> System.out.printf("%c -> %d", key, value));
    }
}
