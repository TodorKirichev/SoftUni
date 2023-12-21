package TextProcessingExercise;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        String number = scan.nextLine();
//        int digit = Integer.parseInt(scan.nextLine());
//        int over = 0;
//        StringBuilder totalSum = new StringBuilder();
//
//        for (int i = number.length() - 1; i >= 0; i--) {
//            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
//            int currentSum = num * digit + over;
//            totalSum.append(currentSum % 10);
//            over = currentSum / 10;
//        }
//        if (over > 0) {
//            totalSum.append(over);
//        }
//        totalSum.reverse();
//        System.out.println(totalSum);

        BigInteger first = new BigInteger(scan.nextLine());
        BigInteger second = new BigInteger(scan.nextLine());

        System.out.println(first.multiply(second));
    }
}
