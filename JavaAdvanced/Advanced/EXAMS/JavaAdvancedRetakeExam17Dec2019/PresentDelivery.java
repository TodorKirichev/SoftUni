package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam17Dec2019;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int presents = Integer.parseInt(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());

        int santaRow = 0;
        int santaCol = 0;

        int initialPresents = presents;

        char[][] matrix = new char[size][size];
        for (int i = 0; i < matrix.length; i++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
                if (matrix[i][j] == 'S') {
                    santaRow = i;
                    santaCol = j;
                }
            }
        }
        String command = scan.nextLine();
        while (!"Christmas morning".equals(command)) {

            matrix[santaRow][santaCol] = '-';

            switch (command) {
                case"up":
                    santaRow--;
                    break;
                case"down":
                    santaRow++;
                    break;
                case"left":
                    santaCol--;
                    break;
                case"right":
                    santaCol++;
                    break;
            }
            if (matrix[santaRow][santaCol] == 'V') {
                presents--;
            }
            if (matrix[santaRow][santaCol] == 'C') {
                if (isKid(matrix,santaRow - 1,santaCol)) {
                    matrix[santaRow - 1][santaCol] = '-';
                    presents--;
                }
                if (isKid(matrix,santaRow + 1,santaCol)) {
                    matrix[santaRow + 1][santaCol] = '-';
                    presents--;
                }
                if (isKid(matrix,santaRow,santaCol - 1)) {
                    matrix[santaRow][santaCol - 1] = '-';
                    presents--;
                }
                if (isKid(matrix,santaRow,santaCol + 1)) {
                    matrix[santaRow][santaCol + 1] = '-';
                    presents--;
                }
            }
            matrix[santaRow][santaCol] = '-';
            if (presents == 0) {
                break;
            }

            command = scan.nextLine();
        }
        matrix[santaRow][santaCol] = 'S';
        if (presents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        print(matrix);
        int kidsLeft = findKidsLeft(matrix);
        if (kidsLeft == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n",initialPresents - presents);
        } else {
            System.out.printf("No presents for %d nice kid/s.\n",kidsLeft);
        }
    }

    private static int findKidsLeft(char[][] matrix) {
        int kids = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'V') {
                    kids++;
                }
            }
        }
        return kids;
    }


    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isKid(char[][] matrix, int row,int col) {
        return matrix[row][col] == 'V' || matrix[row][col] == 'X';
    }
}
