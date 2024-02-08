package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam23October2021;

import java.util.Scanner;

import static java.lang.System.in;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int n = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[n][n];

        int mouseRow = 0;
        int mouseCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'M') {
                    mouseRow = i;
                    mouseCol = j;
                }
            }
        }
        int cheeseEaten = 0;
        boolean isOutside = false;

        String command = scan.nextLine();
        while (!command.equals("end")) {

            matrix[mouseRow][mouseCol] = '-';

            switch (command) {
                case "up":
                    if (mouseRow - 1 >= 0) {
                        mouseRow--;
                        if (matrix[mouseRow][mouseCol] == 'B') {
                            matrix[mouseRow][mouseCol] = '-';
                            if (mouseRow - 1 >= 0) {
                                mouseRow--;
                            } else {
                                isOutside = true;
                            }
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "down":
                    if (mouseRow + 1 < matrix.length) {
                        mouseRow++;
                        if (matrix[mouseRow][mouseCol] == 'B') {
                            matrix[mouseRow][mouseCol] = '-';
                            if (mouseRow + 1 < matrix.length) {
                                mouseRow++;
                            } else {
                                isOutside = true;
                            }
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "left":
                    if (mouseCol - 1 >= 0) {
                        mouseCol--;
                        if (matrix[mouseRow][mouseCol] == 'B') {
                            matrix[mouseRow][mouseCol] = '-';
                            if (mouseCol - 1 >= 0) {
                                mouseCol--;
                            } else {
                                isOutside = true;
                            }
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "right":
                    if (mouseCol + 1 < matrix[0].length) {
                        mouseCol++;
                        if (matrix[mouseRow][mouseCol] == 'B') {
                            matrix[mouseRow][mouseCol] = '-';
                            if (mouseCol + 1 < matrix[0].length) {
                                mouseCol++;
                            } else {
                                isOutside = true;
                            }
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
            }
            if (isOutside) {
                System.out.println("Where is the mouse?");
                break;
            }
            if (matrix[mouseRow][mouseCol] == 'c') {
                matrix[mouseRow][mouseCol] = '-';
                cheeseEaten++;
            }

            command = scan.nextLine();
        }
        if (!isOutside) {
            matrix[mouseRow][mouseCol] = 'M';
        }
        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheeseEaten);
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
}
