package TextProcessingExercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        double totalSum = 0;

        for (String data : input) {
            char first = data.charAt(0);
            char last = data.charAt(data.length() - 1);
            double number = Double.parseDouble(data.substring(1,data.length() - 1));
            int position ;

            if (Character.isUpperCase(first)) {
                position = first - 64;
                number /= position;
            } else {
                position = first - 96;
                number *= position;
            }
            if (Character.isUpperCase(last)) {
                position = last - 64;
                number -= position;
            } else {
                position = last - 96;
                number += position;
            }
            totalSum += number;
        }
        System.out.printf("%.2f",totalSum);
    }
}
