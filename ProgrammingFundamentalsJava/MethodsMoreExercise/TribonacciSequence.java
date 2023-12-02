package MethodsMoreExercise;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

            printTribonacci(n);
    }
    public static void printTribonacci(int n) {
        int [] numbers = new int[n];
        numbers[0] = 1;
        if (n > 1) {
            numbers[1]=1;
        }
        if (n > 2) {
            numbers[2] = 2;
        }
        for (int i = 3; i < n; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2] + numbers[i - 3];
        }
        for (int i : numbers) {
            System.out.printf("%d ",i);
        }
    }
}
