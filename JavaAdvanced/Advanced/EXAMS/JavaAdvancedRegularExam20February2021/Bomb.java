package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam20February2021;

import java.util.Scanner;

import static java.lang.System.in;

public class Bomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];
        String[] commands = scan.nextLine().split(",");

        int sapperRow = 0;
        int sapperCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] line = scan.nextLine().split("\\s+");
            matrix[i] = new char[line.length];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = line[j].charAt(0);
                if (matrix[i][j] == 's') {
                    sapperRow = i;
                    sapperCol = j;
                }
            }
        }
        boolean isEndOfRoute = false;

        for (String command : commands) {
            matrix[sapperRow][sapperCol] = '+';

            switch (command) {
                case "up":
                    if (sapperRow - 1 >= 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow + 1 < matrix.length) {
                        sapperRow++;
                    }
                    break;
                case "left":
                    if (sapperCol - 1 >= 0) {
                        sapperCol--;
                    }
                    break;
                case "right":
                    if (sapperCol + 1 < matrix[sapperRow].length) {
                        sapperCol++;
                    }
                    break;
            }
            if (matrix[sapperRow][sapperCol] == 'B') {
                matrix[sapperRow][sapperCol] = '+';
                System.out.println("You found a bomb!");
            }
            if (checkForBombs(matrix) == 0) {
                break;
            }
            if (matrix[sapperRow][sapperCol] == 'e') {
                isEndOfRoute = true;
                break;
            }
        }
        int bombsLeft = checkForBombs(matrix);
        if (isEndOfRoute) {
            System.out.printf("END! %d bombs left on the field\n",bombsLeft);
        } else {
            if (bombsLeft == 0) {
                System.out.println("Congratulations! You found all bombs!");
            } else {
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)\n",bombsLeft,sapperRow,sapperCol);
            }
        }
    }

    private static int checkForBombs(char[][] matrix) {
        int bombs = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    bombs++;
                }
            }
        }
        return bombs;
    }
}
