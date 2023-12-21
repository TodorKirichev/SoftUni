package JavaFundamentals.BitwiseOperations;

import java.util.Scanner;

public class BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int binaryDigit = Integer.parseInt(scan.nextLine());
        int counter = 0;

        while (n > 0) {
            int leftOver = n % 2;
            if (leftOver == binaryDigit) {
                counter++;
            }
            n /= 2;
        }
        System.out.println(counter);
    }
}
