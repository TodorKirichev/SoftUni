package TextProcessingExercise;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char [] input = scan.nextLine().toCharArray();
        StringBuilder result = new StringBuilder();

        char symbol = input[input.length - 1];

        for (int i = input.length - 1; i >= 0 ; i--) {
            char currentSymbol = input[i];

           if (symbol != currentSymbol) {
               result.append(symbol);
               symbol = input[i];
           }
        }
        result.append(symbol);
        result.reverse();
        System.out.println(result);
    }
}
