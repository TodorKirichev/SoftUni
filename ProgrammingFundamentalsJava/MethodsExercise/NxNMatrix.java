package MethodsExercise;

import java.util.Scanner;

public class NxNMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            printRow(n);
            System.out.println();
        }
    }
    public static void printRow(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");
        }
    }
}
