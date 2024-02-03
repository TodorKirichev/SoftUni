package JavaAdvanced.MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class _3_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][];

        readMatrix(scan, matrix);
        int difference = getDiagonalDifference(matrix);
        System.out.println(difference);

    }

    private static int getDiagonalDifference(int[][] matrix) {
        int difference;
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal += matrix[i][i];
            secondDiagonal += matrix[i][matrix[i].length - 1 - i];
        }
        difference = Math.abs(firstDiagonal - secondDiagonal);
        return difference;
    }

    private static void readMatrix(Scanner scan, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
