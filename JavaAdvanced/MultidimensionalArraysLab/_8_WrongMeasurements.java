package JavaAdvanced.MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class _8_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        String[] wrongValuesCoordinates = scan.nextLine().split(" ");
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        int wrongValue = matrix[Integer.parseInt(wrongValuesCoordinates[0])][Integer.parseInt(wrongValuesCoordinates[1])];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                changeElement(matrix,row,col,wrongValue,newMatrix);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void changeElement(int[][] matrix, int row, int col, int wrongValue, int[][] newMatrix) {
        int element = matrix[row][col];
        int sum = 0;
        if (element == wrongValue) {
            if (row >= 1) {
                if (matrix[row - 1][col] != wrongValue) {
                    sum += matrix[row - 1][col];
                }
            }
            if (row < matrix.length - 1) {
                if (matrix[row + 1][col] != wrongValue) {
                    sum += matrix[row + 1][col];
                }
            }
            if (col >= 1) {
                if (matrix[row][col - 1] != wrongValue) {
                    sum += matrix[row][col - 1];
                }
            }
            if (col < matrix[row].length - 1) {
                if (matrix[row][col + 1] != wrongValue) {
                    sum += matrix[row][col + 1];
                }
            }
            newMatrix[row][col] = sum;
        } else {
            newMatrix[row][col] = matrix[row][col];
        }
    }
}
