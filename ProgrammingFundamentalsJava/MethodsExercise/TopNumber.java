package MethodsExercise;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());

        printTopInteger(num);
    }
    public static boolean checkDivisible8(int i) {
        boolean isTrue = false;
        int sum = 0;
        while (i > 0) {
            int lastDigit = i % 10;
            sum += lastDigit;
            i /= 10;
        }
        if (sum % 8 ==0) {
            isTrue = true;
        }
        return isTrue;
    }
    public static boolean checkOdd(int i) {
        boolean isTrue = false;
        while (i > 0) {
            int lastDigit = i % 10;
            if (lastDigit % 2 != 0) {
                isTrue = true;
                break;
            } else {
                i /= 10;
            }
        }
        return isTrue;
    }
    public static void printTopInteger(int num) {
        for (int i = 0; i < num; i++) {

            if (checkDivisible8(i)) {
                if (checkOdd(i)) {
                    System.out.println(i);
                }
            }
        }
    }
}
