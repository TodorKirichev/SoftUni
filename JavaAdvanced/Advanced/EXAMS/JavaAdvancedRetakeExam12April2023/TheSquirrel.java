package Exams.EXAMS.JavaAdvancedRetakeExam12April2023;

import java.util.Scanner;

import static java.lang.System.in;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int hazelnuts = 0;

        int size = Integer.parseInt(scan.nextLine());

        String[] moves = scan.nextLine().split(", ");

        int squirrelRow = 0;
        int squirrelCol = 0;

        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 's') {
                    squirrelRow = i;
                    squirrelCol = j;
                }
            }
        }
        int counter = 0;
        boolean isTrapped = false;
        boolean isOutside = false;

        for (String move : moves) {
            char symbol;

            switch (move) {
                case "up":
                    if (squirrelRow > 0) {
                        matrix[squirrelRow][squirrelCol] = '*';
                        squirrelRow--;
                        symbol = matrix[squirrelRow][squirrelCol];
                        if (symbol == '*') {
                            continue;
                        }
                        if (symbol == 'h') {
                            hazelnuts++;
                        }
                        if (symbol == 't') {
                            isTrapped = true;
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "down":
                    if (squirrelRow < matrix.length - 1) {
                        matrix[squirrelRow][squirrelCol] = '*';
                        squirrelRow++;
                        symbol = matrix[squirrelRow][squirrelCol];
                        if (symbol == '*') {
                            continue;
                        }
                        if (symbol == 'h') {
                            hazelnuts++;
                        }
                        if (symbol == 't') {
                            isTrapped = true;
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "left":
                    if (squirrelCol > 0) {
                        matrix[squirrelRow][squirrelCol] = '*';
                        squirrelCol--;
                        symbol = matrix[squirrelRow][squirrelCol];
                        if (symbol == '*') {
                            continue;
                        }
                        if (symbol == 'h') {
                            hazelnuts++;
                        }
                        if (symbol == 't') {
                            isTrapped = true;
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "right":
                    if (squirrelCol < matrix[0].length - 1) {
                        matrix[squirrelRow][squirrelCol] = '*';
                        squirrelCol++;
                        symbol = matrix[squirrelRow][squirrelCol];
                        if (symbol == '*') {
                            continue;
                        }
                        if (symbol == 'h') {
                            hazelnuts++;
                        }
                        if (symbol == 't') {
                            isTrapped = true;
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
            }
            if (isOutside) {
                System.out.println("The squirrel is out of the field.");
                break;
            }
            if (isTrapped) {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                break;
            }
        }
        if (!isTrapped && !isOutside) {
            if (hazelnuts == 3) {
                System.out.println("Good job! You have collected all hazelnuts!");
            } else {
                System.out.println("There are more hazelnuts to collect.");
            }
        }
        System.out.printf("Hazelnuts collected: %d",hazelnuts);
    }
}
