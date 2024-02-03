package JavaAdvanced.MultidimensionalArraysLab;

import java.util.Scanner;

public class _3_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        String[][] firstMatrix = new String[rows][];
        String[][] secondMatrix = new String[rows][];
        for (int i = 0; i < firstMatrix.length; i++) {
            firstMatrix[i]= scan.nextLine().split(" ");
        }
        for (int i = 0; i < secondMatrix.length; i++) {
            secondMatrix[i] = scan.nextLine().split(" ");
        }
        String[][] thirdMatrix = new String[rows][cols];
        fillThird(firstMatrix,secondMatrix,thirdMatrix);
        for (String[] s : thirdMatrix) {
            System.out.print(String.join(" ",s));
            System.out.println();
        }
    }

    private static void fillThird(String[][] firstMatrix, String[][] secondMatrix, String[][] thirdMatrix) {
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (!firstMatrix[i][j].equals(secondMatrix[i][j])) {
                    thirdMatrix[i][j] = "*";
                } else {
                    thirdMatrix[i][j] = firstMatrix[i][j];
                }
            }
        }
    }
}
