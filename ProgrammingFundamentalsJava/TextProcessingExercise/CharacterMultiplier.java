package TextProcessingExercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        String first = input[0];
        String second = input[1];

        int sum = multiply(first,second);
        System.out.println(sum);
    }

    private static int multiply(String first, String second) {
        int sum = 0;
        for (int i = 0; i < Math.min(first.length(),second.length()); i++) {
            sum += first.charAt(i) * second.charAt(i);
        }
        if (first.length() > second.length()) {
            for (int i = second.length(); i < first.length(); i++) {
                sum += first.charAt(i);
            }
        } else if (second.length() > first.length()) {
            for (int i = first.length(); i < second.length(); i++) {
                sum += second.charAt(i);
            }
        }
        return sum;
    }
}
