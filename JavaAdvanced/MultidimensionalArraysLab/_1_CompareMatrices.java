package JavaAdvanced.MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class _1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstMatrixRows = scan.nextInt();
        int firstMatrixCols = scan.nextInt();
        scan.nextLine();
        
        int[][] firstMatrix = new int[firstMatrixRows][];
        for (int i = 0; i < firstMatrix.length; i++) {
            firstMatrix[i] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int secondMatrixRows = scan.nextInt();
        int secondMatrixCols = scan.nextInt();
        scan.nextLine();

        int[][] secondMatrix = new int[secondMatrixRows][];
        for (int i = 0; i < secondMatrix.length; i++) {
            secondMatrix[i] = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(areMatrixEqual(firstMatrix,secondMatrix) ? "equal" : "not equal");
    }
    private static boolean areMatrixEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        } else {
            for (int i = 0; i < firstMatrix.length; i++) {
                if (firstMatrix[i].length != secondMatrix[i].length) {
                    return false;
                }
                for (int j = 0; j < firstMatrix[i].length; j++) {
                    if (firstMatrix[i][j] != secondMatrix[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
