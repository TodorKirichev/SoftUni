package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lastDigit = numbers[numbers.length - 1];

        for (int i = 0; i < numbers.length; i++) {
            int digit = numbers[i];
           boolean isTopInteger = false;
            for (int j = i + 1; j < numbers.length ; j++) {
                int rightNum = numbers[j];

                if (digit > rightNum) {
                    isTopInteger = true;
                } else {
                    isTopInteger = false;
                    break;
                }
            }
            if (isTopInteger) {
                System.out.print(digit + " ");
            }
        }
        System.out.print(lastDigit);
    }
}
