package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam28June2020;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        char[][] territory  = new char[size][size];

        int snakeRow = 0;
        int snakeCol = 0;

        for (int i = 0; i < territory .length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                territory [i][j] = line.charAt(j);
                if (territory [i][j] == 'S') {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }
        boolean isOutside = false;
        int food = 0;

        while (true) {
            String command = scan.nextLine();
            territory [snakeRow][snakeCol] = '.';

            switch (command) {
                case "up":
                    if (snakeRow - 1 < 0) {
                        isOutside = true;
                    } else {
                        snakeRow--;
                    }
                    break;
                case "down":
                    if (snakeRow + 1 > territory .length - 1) {
                        isOutside = true;
                    } else {
                        snakeRow++;
                    }
                    break;
                case "left":
                    if (snakeCol - 1 < 0) {
                        isOutside = true;
                    } else {
                        snakeCol--;
                    }
                    break;
                case "right":
                    if (snakeCol + 1 > territory [snakeRow].length - 1) {
                        isOutside = true;
                    } else {
                        snakeCol++;
                    }
                    break;
            }
            if (isOutside) {
                 break;
            }
            if (territory [snakeRow][snakeCol] == '*') {
                food++;
            }
            if (food == 10) {
                break;
            }
            if (territory [snakeRow][snakeCol] == 'B') {
                territory [snakeRow][snakeCol] = '.';
                for (int i = 0; i < territory .length; i++) {
                    for (int j = 0; j < territory [i].length; j++) {
                        if (territory [i][j] == 'B') {
                            snakeRow = i;
                            snakeCol = j;
                        }
                    }
                }
            }
            territory [snakeRow][snakeCol] = '.';
        }
        if (isOutside) {
            System.out.println("Game over!");
        } else {
            territory [snakeRow][snakeCol] = 'S';
        }
        if (food == 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d\n",food);
        print(territory );
    }

    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
