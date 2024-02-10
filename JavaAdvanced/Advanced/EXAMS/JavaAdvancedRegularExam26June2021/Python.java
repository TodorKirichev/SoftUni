package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam26June2021;

import java.util.Scanner;

import static java.lang.System.in;

public class Python {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];

        String[] commands = scan.nextLine().split(", ");

        int snakeRow = 0;
        int snakeCol = 0;

        int snakeLength = 1;

        for (int i = 0; i < matrix.length; i++) {
            String[] line = scan.nextLine().split("\\s+");
            matrix[i] = new char[line.length];
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
                if (matrix[i][j] == 's') {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }
        for (String command : commands) {
            switch (command) {
                case "up":
                    if (snakeRow - 1 < 0) {
                        snakeRow = matrix.length - 1;
                    } else {
                        snakeRow--;
                    }
                    break;
                case "down":
                    if (snakeRow + 1 > matrix.length - 1) {
                        snakeRow = 0;
                    } else {
                        snakeRow++;
                    }
                    break;
                case "left":
                    if (snakeCol - 1 < 0) {
                        snakeCol = matrix[snakeRow].length - 1;
                    } else {
                        snakeCol--;
                    }
                    break;
                case "right":
                    if (snakeCol + 1 > matrix[snakeRow].length - 1) {
                        snakeCol = 0;
                    } else {
                        snakeCol++;
                    }
                    break;
            }
            if (matrix[snakeRow][snakeCol] == 'f') {
                snakeLength++;
                matrix[snakeRow][snakeCol] = '*';
                if (isAllFoodEaten(matrix)) {
                    break;
                }
            }
            if (matrix[snakeRow][snakeCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }
        if (isAllFoodEaten(matrix)) {
            System.out.printf("You win! Final python length is %d\n",snakeLength);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.\n",countFoodLeft(matrix));
        }
    }

    private static boolean isAllFoodEaten(char[][] matrix) {
        boolean isEaten = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'f') {
                    isEaten = false;
                    break;
                }
            }
        }
        return isEaten;
    }
    public static int countFoodLeft(char[][] matrix) {
        int foodLeft = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'f') {
                    foodLeft++;
                }
            }
        }
        return foodLeft;
    }
}
