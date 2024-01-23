package JavaAdvanced.MultidimensionalArraysLab;

import java.util.Scanner;

public class _6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[size][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split(" ");
        }
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        int count = 0;
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(matrix[i][count] + " ");
            count++;
        }
    }
}
