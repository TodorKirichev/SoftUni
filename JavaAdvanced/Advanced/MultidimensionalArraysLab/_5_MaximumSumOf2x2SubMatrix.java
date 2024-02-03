package JavaAdvanced.MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class _5_MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] dimensions = scan.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int sum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[2][2];

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int currentSum = 0;
                int index1 = matrix[i][j];
                int index2 = matrix[i][j + 1];
                int index3 = matrix[i + 1][j];
                int index4 = matrix[i + 1][j + 1];
                currentSum = index1 + index2 + index3 + index4;
                if (currentSum > sum) {
                    sum = currentSum;
                    subMatrix[0][0] = index1;
                    subMatrix[0][1] = index2;
                    subMatrix[1][0] = index3;
                    subMatrix[1][1] = index4;
                }
            }
        }
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[i].length; j++) {
                System.out.print(subMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
