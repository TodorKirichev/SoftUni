package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();


        int maxLength = 0;
        int startIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            int length = 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    length++;
                    if (length > maxLength){
                        maxLength = length;
                        startIndex = i;
                    }
                } else {
                    length = 1;
                    break;
                }
            }
        }
        for (int i = 0; i < maxLength; i++) {
            System.out.print(numbers[startIndex] + " ");
        }
    }
}
