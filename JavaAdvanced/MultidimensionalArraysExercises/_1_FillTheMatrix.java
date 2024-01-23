package JavaAdvanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class _1_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] instructions = scan.nextLine().split(", ");
        int size = Integer.parseInt(instructions[0]);
        char pattern = instructions[1].charAt(0);

        int[][] matrix = new int[size][size];
        switch (pattern) {
            case 'A':
                fillMatrixA(matrix);
                break;
            case 'B':
                fillMatrixB(matrix);
                break;
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixB(int[][] matrix) {
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix[row].length; col ++) {
                    matrix[col][row] = counter;
                    counter++;
                }
            } else {
                for (int col = matrix[row].length - 1; col >= 0; col --) {
                    matrix[col][row] = counter;
                    counter++;
                }
            }
        }
    }

    private static void fillMatrixA(int[][] matrix) {
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = counter;
                counter++;
            }
        }
    }
}
