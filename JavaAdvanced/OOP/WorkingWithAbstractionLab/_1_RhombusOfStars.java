package JavaAdvanced.OOP.WorkingWithAbstractionLab;

import java.util.Scanner;

import static java.lang.System.in;

public class _1_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int n = Integer.parseInt(scan.nextLine());

        printTop(n);
        printRow(n,n);
        printBottom(n);

    }

    private static void printBottom(int n) {
        for (int i = n - 1; i > 0; i--) {
            printRow(n,i);
        }
    }

    private static void printTop(int n) {
        for (int i = 0; i < n; i++) {
            printRow(n, i);
        }
    }

    private static void printRow(int n, int i) {
        for (int j = 0; j < n - i; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < i; j++) {
            System.out.print('*' + " ");
        }
        System.out.println();
    }
}
