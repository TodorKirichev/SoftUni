package JavaAdvanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class _2_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

         int rows = scan.nextInt();
         int cols = scan.nextInt();
         scan.nextLine();
         String[][] matrix = new String[rows][cols];

        fillMatrix(matrix);
        changeMidLetter(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            System.out.print(String.join(" ",strings));
            System.out.println();
        }
    }

    private static void changeMidLetter(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                StringBuilder text = new StringBuilder(matrix[row][col]);
                char letter = text.charAt(1);
                char newLetter = (char) (letter + col);
                text.replace(1,2,String.valueOf(newLetter));
                matrix[row][col] = text.toString();
            }
        }
    }

    private static void fillMatrix(String[][] matrix) {
        char firstLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.valueOf((char) (firstLetter + row));
                for (int i = 0; i < 2; i++) {
                    matrix[row][col] += (char)(firstLetter + row);
                }
            }
        }
    }
}
