package Exams.EXAMS.JavaAdvancedRegularExam17June2023;

import java.util.Scanner;

import static java.lang.System.in;

public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] line = scan.nextLine().split(",");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        char[][] matrix = new char[rows][cols];

        fillMatrix(rows, scan, matrix);

        int mouseRow = 0;
        int mouseCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 'M') {
                    mouseRow = i;
                    mouseCol = j;
                }
            }
        }


        boolean isTrapped = false;

        while (true) {
            String command = scan.nextLine();
            if (command.equals("danger")) {
                break;
            }
            boolean isOutside = false;
            switch (command) {
                case "up":
                    if (isVerticalMoveLegal(matrix,mouseRow - 1)) {
                        if (matrix[mouseRow - 1][mouseCol] != '@') {
                            if (matrix[mouseRow - 1][mouseCol] == 'T') {
                                isTrapped = true;
                            }
                            matrix[mouseRow][mouseCol] = '*';
                            mouseRow -= 1;
                            matrix[mouseRow][mouseCol] = 'M';
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "down":
                    if (isVerticalMoveLegal(matrix,mouseRow + 1)) {
                        if (matrix[mouseRow + 1][mouseCol] != '@') {
                            if (matrix[mouseRow + 1][mouseCol] == 'T') {
                                isTrapped = true;
                            }
                            matrix[mouseRow][mouseCol] = '*';
                            mouseRow += 1;
                            matrix[mouseRow][mouseCol] = 'M';
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "left":
                    if (isHorizontalMoveLegal(matrix,mouseCol - 1)) {
                        if (matrix[mouseRow][mouseCol - 1] != '@') {
                            if (matrix[mouseRow][mouseCol - 1] == 'T') {
                                isTrapped = true;
                            }
                            matrix[mouseRow][mouseCol] = '*';
                            mouseCol -= 1;
                            matrix[mouseRow][mouseCol] = 'M';
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "right":
                    if (isHorizontalMoveLegal(matrix,mouseCol + 1)) {
                        if (matrix[mouseRow][mouseCol + 1] != '@') {
                            if (matrix[mouseRow][mouseCol + 1] == 'T') {
                                isTrapped = true;
                            }
                            matrix[mouseRow][mouseCol] = '*';
                            mouseCol += 1;
                            matrix[mouseRow][mouseCol] = 'M';
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
            }
            if (isOutside) {
                System.out.println("No more cheese for tonight!");
                printMatrix(matrix);
                return;
            }
            if (!isThereCheese(matrix)) {
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                printMatrix(matrix);
                return;
            }
            if (isTrapped) {
                System.out.println("Mouse is trapped!");
                printMatrix(matrix);
                return;
            }
        }
        if (isThereCheese(matrix)) {
            System.out.println("Mouse will come back later!");
        }
        printMatrix(matrix);
    }

    private static boolean isHorizontalMoveLegal(char[][] matrix, int mouseCol) {
        return mouseCol >= 0 && mouseCol < matrix[0].length;
    }

    private static boolean isVerticalMoveLegal(char[][] matrix, int mouseRow) {
        return mouseRow >= 0 && mouseRow < matrix.length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isThereCheese(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'C') {
                    return true;
                }
            }
        }
        return false;
    }
    private static void fillMatrix(int rows, Scanner scan, char[][] matrix) {
        for (int i = 0; i < rows; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }
}
