package JavaAdvanced.MultidimensionalArraysLab;

import java.util.Scanner;

public class _7_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        for (int i = 0; i < matrix.length; i++) {
            String[] line = scan.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentChar = matrix[row][col];
                if (currentChar == 'q') {
                    if (checkPosition(matrix,row,col)) {
                        System.out.println(row + " " + col);
                    }
                }
            }
        }
    }

    private static boolean checkPosition(char[][] matrix, int row, int col) {
        for (int i = 0 ; i < col - 1; i++) {
            char ch = matrix[row][i];
            if (check(ch)) {
                return false;
            }
        }
        for (int i = col + 1; i < matrix[row].length; i++) {
            char ch = matrix[row][i];
            if (check(ch)) {
                return false;
            }
        }
        for (int i = 0; i < row - 1; i++) {
            char ch = matrix[i][col];
            if (check(ch)) {
                return false;
            }
        }
        for (int i = row + 1; i < matrix.length ; i++) {
            char ch = matrix[i][col];
            if (check(ch)) {
                return false;
            }
        }

        for (int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
            char ch = matrix[i][j];
            if (check(ch)) {
                return false;
            }
        }
        for (int i = row + 1,j = col + 1; i < matrix.length && j < matrix[col].length; i++,j++) {
            char ch = matrix[i][j];
            if (check(ch)) {
                return false;
            }
        }
        for (int i = row - 1,j = col + 1; i >= 0 && j < matrix[col].length; i--,j++) {
            char ch = matrix[i][j];
            if (check(ch)) {
                return false;
            }
        }
        for (int i = row + 1,j = col - 1; i < matrix.length && j >= 0; i++,j--) {
            char ch = matrix[i][j];
            if (check(ch)) {
                return false;
            }
        }
        return true;
    }
    private static boolean check(char ch) {
        return ch == 'q';
    }
}