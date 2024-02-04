package JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam21October2023;

import java.util.Scanner;

import static java.lang.System.in;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        char[][] matrix = fillMatrix(scan);

        int shipRow = 0;
        int shipCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                char ch = matrix[i][j];
                if (ch == 'S') {
                    shipRow = i;
                    shipCol = j;
                }
            }
        }
        int tons = 0;
        boolean isSink = false;

        while (true) {
            String command = scan.nextLine();
            if (command.equals("collect the nets")) {
                break;
            }
            matrix[shipRow][shipCol] = '-';
            switch (command) {
                case "up" :
                    if (shipRow - 1 < 0) {
                        shipRow = matrix.length - 1;
                    } else {
                        shipRow -= 1;
                    }
                    if (Character.isDigit(matrix[shipRow][shipCol])) {
                        tons += Integer.parseInt(String.valueOf(matrix[shipRow][shipCol]));
                    } else if (matrix[shipRow][shipCol] == 'W') {
                        tons = 0;
                        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                                "Last coordinates of the ship: [%d,%d]\n",shipRow,shipCol);
                        isSink = true;
                    }
                    break;
                case "down" :
                    if (shipRow + 1 > matrix.length - 1) {
                        shipRow = 0;
                    } else {
                        shipRow += 1;
                    }
                    if (Character.isDigit(matrix[shipRow][shipCol])) {
                        tons += Integer.parseInt(String.valueOf(matrix[shipRow][shipCol]));
                    } else if (matrix[shipRow][shipCol] == 'W') {
                        tons = 0;
                        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                                "Last coordinates of the ship: [%d,%d]\n",shipRow,shipCol);
                        isSink = true;
                    }
                    break;
                case "left" :
                    if (shipCol - 1 < 0) {
                        shipCol = matrix.length - 1;
                    } else {
                        shipCol -= 1;
                    }
                    if (Character.isDigit(matrix[shipRow][shipCol])) {
                        tons += Integer.parseInt(String.valueOf(matrix[shipRow][shipCol]));
                    } else if (matrix[shipRow][shipCol] == 'W') {
                        tons = 0;
                        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                                "Last coordinates of the ship: [%d,%d]\n",shipRow,shipCol);
                        isSink = true;
                    }
                    break;
                case "right" :
                    if (shipCol + 1 > matrix[0].length - 1) {
                        shipCol = 0;
                    } else {
                        shipCol += 1;
                    }
                    if (Character.isDigit(matrix[shipRow][shipCol])) {
                        tons += Integer.parseInt(String.valueOf(matrix[shipRow][shipCol]));
                    } else if (matrix[shipRow][shipCol] == 'W') {
                        tons = 0;
                        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                                "Last coordinates of the ship: [%d,%d]\n",shipRow,shipCol);
                        isSink = true;
                    }
                    break;
            }
            matrix[shipRow][shipCol] = 'S';
            if (isSink) {
                return;
            }
        }
        if (tons >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! " +
                    "You need %d tons of fish more.\n",20 - tons);
        }
        if (tons > 0) {
            System.out.printf("Amount of fish caught: %d tons.\n",tons);
        }
        if (!isSink) {
            getPrintMatrix(matrix);
        }
    }

    private static void getPrintMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isMovingPossible(char[][] matrix,int shipRow, int shipCol) {
        return shipRow > 0
                && shipRow < matrix.length - 1
                && shipCol > 0
                &&shipCol < matrix[0].length - 1;
    }

    private static char[][] fillMatrix(Scanner scan) {
        int n = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        return matrix;
    }
}
