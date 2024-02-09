package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam14April2021;

import java.util.Scanner;

import static java.lang.System.in;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];

        int playerRow = 0;
        int playerCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'S') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        int money = 0;
        boolean isOutside = false;

        while (true) {
            String command = scan.nextLine();
            matrix[playerRow][playerCol] = '-';

            switch (command) {
                case "up":
                    if (playerRow - 1 < 0) {
                        isOutside = true;
                    } else {
                        playerRow--;
                    }
                    break;
                case "down":
                    if (playerRow + 1 > matrix.length - 1) {
                        isOutside = true;
                    } else {
                        playerRow++;
                    }
                    break;
                case "left":
                    if (playerCol - 1 < 0) {
                        isOutside = true;
                    } else {
                        playerCol--;
                    }
                    break;
                case "right":
                    if (playerCol + 1 > matrix[playerRow].length - 1) {
                        isOutside = true;
                    } else {
                        playerCol++;
                    }
                    break;
            }
            if (isOutside) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
            if (Character.isDigit(matrix[playerRow][playerCol])) {
                money += Integer.parseInt(String.valueOf(matrix[playerRow][playerCol]));
                if (money >= 50) {
                    System.out.println("Good news! You succeeded in collecting enough money!");
                    break;
                }
            }
            if (matrix[playerRow][playerCol] == 'P') {
                matrix[playerRow][playerCol] = '-';
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (matrix[i][j] == 'P') {
                            playerRow = i;
                            playerCol = j;
                        }
                    }
                }
            }
            matrix[playerRow][playerCol] = '-';
        }
        if (!isOutside) {
            matrix[playerRow][playerCol] = 'S';
        }
        System.out.printf("Money: %d\n",money);
        print(matrix, playerRow);
    }

    private static void print(char[][] matrix, int playerRow) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[playerRow].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
