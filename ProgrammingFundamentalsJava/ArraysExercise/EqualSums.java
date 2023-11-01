package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        boolean isEqual = false;

        for (int i = 0; i < numbers.length; i++) {
            int digit = numbers[i];
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                int leftDigit = numbers[j];
                leftSum += leftDigit;
            }
            for (int j = i + 1; j < numbers.length ; j++) {
                int rightDigit = numbers[j];
                rightSum += rightDigit;
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                isEqual = true;
                break;
            }
        }
        if (!isEqual) {
            System.out.println("no");
        }
    }
}
