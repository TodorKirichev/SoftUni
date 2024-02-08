package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam18August2021;

import java.util.Scanner;

import static java.lang.System.in;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int size = Integer.parseInt(scan.nextLine());
        int countOfCommands = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int playerRow = 0;
        int playerCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = new char[line.length()];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        boolean isFinished = false;
        for (int i = 0; i < countOfCommands; i++) {
            matrix[playerRow][playerCol] = '.';

            String command = scan.nextLine();
            switch (command) {
                case "up":
                    playerRow = moveUp(playerRow, matrix);
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerRow = moveUp(playerRow, matrix);
                    } else if (matrix[playerRow][playerCol] == 'T') {
                        playerRow = moveDown(playerRow, matrix);
                    }
                    break;
                case "down":
                    playerRow = moveDown(playerRow, matrix);
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerRow = moveDown(playerRow, matrix);
                    } else if (matrix[playerRow][playerCol] == 'T') {
                        playerRow = moveUp(playerRow, matrix);
                    }
                    break;
                case "left":
                    playerCol = moveLeft(playerCol, matrix, playerRow);
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerCol = moveLeft(playerCol, matrix, playerRow);
                    } else if (matrix[playerRow][playerCol] == 'T') {
                        playerCol = moveRight(playerCol, matrix, playerRow);
                    }
                    break;
                case "right":
                    playerCol = moveRight(playerCol, matrix, playerRow);
                    if (matrix[playerRow][playerCol] == 'B') {
                        playerCol = moveRight(playerCol, matrix, playerRow);
                    } else if (matrix[playerRow][playerCol] == 'T') {
                        playerCol = moveLeft(playerCol, matrix, playerRow);
                    }
                    break;
            }
            if (matrix[playerRow][playerCol] == 'F') {
                isFinished = true;
                break;
            }
        }
        matrix[playerRow][playerCol] = 'P';
        if (isFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        print(matrix);
    }

    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int moveRight(int playerCol, char[][] matrix, int playerRow) {
        if (playerCol + 1 > matrix[playerRow].length - 1) {
            playerCol = 0;
        } else {
            playerCol++;
        }
        return playerCol;
    }

    private static int moveLeft(int playerCol, char[][] matrix, int playerRow) {
        if (playerCol - 1 < 0) {
            playerCol = matrix[playerRow].length - 1;
        } else {
            playerCol--;
        }
        return playerCol;
    }

    private static int moveDown(int playerRow, char[][] matrix) {
        if (playerRow + 1 > matrix.length - 1) {
            playerRow = 0;
        } else {
            playerRow++;
        }
        return playerRow;
    }

    private static int moveUp(int playerRow, char[][] matrix) {
        if (playerRow - 1 < 0) {
            playerRow = matrix.length - 1;
        } else {
            playerRow--;
        }
        return playerRow;
    }
}
