package ArraysMoreExercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] fibonacci = new int[n];

        fibonacci[0] = 1;
        if (n > 1) {
            fibonacci[1] = 1;
        }

        if (n > 2) {
            for (int i = 2; i < n; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
        }
        System.out.println(fibonacci[n - 1]);
    }
}
