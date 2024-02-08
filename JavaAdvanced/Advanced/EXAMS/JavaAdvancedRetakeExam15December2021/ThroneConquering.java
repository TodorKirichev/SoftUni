package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam15December2021;

import java.util.Scanner;

import static java.lang.System.in;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int energy = Integer.parseInt(scan.nextLine());
        int rows = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[rows][];

        int parisRow = 0;
        int parisCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = new char[line.length()];
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'P') {
                    parisRow = i;
                    parisCol = j;
                }
            }
        }
        boolean isAbducted = false;

        while (true) {
            String[] input = scan.nextLine().split("\\s+");
            String direction = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);

            matrix[spartanRow][spartanCol] = 'S';
            matrix[parisRow][parisCol] = '-';

            switch (direction) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < matrix.length) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (parisCol + 1 < matrix[0].length) {
                        parisCol++;
                    }
                    break;
            }
            energy--;
            if (matrix[parisRow][parisCol] == 'H') {
                matrix[parisRow][parisCol] = '-';
                isAbducted = true;
                break;
            }
            if (energy > 0) {
                if (matrix[parisRow][parisCol] == 'S') {
                    energy -= 2;
                    if (energy <= 0) {
                        matrix[parisRow][parisCol] = 'X';
                        break;
                    } else {
                        matrix[parisRow][parisCol] = '-';
                    }
                }
            } else {
                matrix[parisRow][parisCol] = 'X';
                break;
            }

        }
        if (isAbducted) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n",energy);
        } else {
            System.out.printf("Paris died at %s;%s.\n",parisRow,parisCol);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
