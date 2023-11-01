package ArraysMoreExercise;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[][] numbers = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    numbers[i][j] = 1;
                } else {
                    numbers[i][j] = numbers[i-1][j-1] + numbers[i-1][j];
                }
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }
}

