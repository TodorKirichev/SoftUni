package MethodsLab;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        multiply();
    }

    public static int evenSum(int number) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                sum += lastDigit;
            }
            number = number / 10;
        }
        return sum;
    }
    public static int oddSum(int number) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                sum += lastDigit;
            }
            number = number / 10;
        }
        return sum;
    }
    public static void multiply() {
        Scanner scan = new Scanner(System.in);
        int number = Math.abs(Integer.parseInt(scan.nextLine()));
        System.out.println(evenSum(number) * oddSum(number));
    }
}
