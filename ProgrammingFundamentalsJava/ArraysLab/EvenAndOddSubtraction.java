package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int sumEven = 0;
        int sumOdd = 0;

        for (int digit : numbers) {
            if (digit%2==0){
                sumEven+=digit;
            } else {
                sumOdd+=digit;
            }
        }
        System.out.println(sumEven-sumOdd);
    }
}
