package ArraysLab;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int digit = numbers[i];
            if (digit%2==0){
                sum += digit;
            }
        }
        System.out.println(sum);
    }
}
