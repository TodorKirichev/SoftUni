package JavaAdvanced.MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class _11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt();
        int col = scan.nextInt();
        scan.nextLine();

        int[][] matrix = new int[row][col];

        fillMatrix(scan, matrix);

        for (int i = row - 1; i >= 0; i--) {
            if (i == row - 1) {
                for (int j = col - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                    int currentRow = i;
                    int currentCol = j;
                    while (currentRow > 0 && currentCol + 1 < col) {
                        System.out.print(matrix[currentRow - 1][currentCol + 1] + " ");
                        currentRow--;
                        currentCol++;
                    }
                    System.out.println();
                }
            } else {
                for (int j = 0; j < col; j++) {
                    System.out.print(matrix[i][j] + " ");
                    int currentRow = i;
                    int currentCol = j;
                    while (currentRow > 0 && currentCol + 1 < col) {
                        System.out.print(matrix[currentRow - 1][currentCol + 1] + " ");
                        currentRow--;
                        currentCol++;
                    }
                    System.out.println();
                    j = col;
                }
            }
        }

    }

    private static void fillMatrix(Scanner scan, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
