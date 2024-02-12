package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam19August2020;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];

        int beeRow = 0;
        int beeCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            String line = scan.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }
        int pollinatedFlowers = 0;
        boolean isOutside = false;

        String command = scan.nextLine();
        while (!command.equals("End")) {

            matrix[beeRow][beeCol] = '.';
            switch (command) {
                case "up":
                    if (beeRow - 1 < 0) {
                        isOutside = true;
                    } else {
                        beeRow--;
                    }
                    break;
                case "down":
                    if (beeRow + 1 > matrix.length - 1) {
                        isOutside = true;
                    } else {
                        beeRow++;
                    }
                    break;
                case "left":
                    if (beeCol - 1 < 0) {
                        isOutside = true;
                    } else {
                        beeCol--;
                    }
                    break;
                case "right":
                    if (beeCol + 1 > matrix[beeRow].length - 1) {
                        isOutside = true;
                    } else {
                        beeCol++;
                    }
                    break;
            }
            char symbol = matrix[beeRow][beeCol];
            if (isOutside) {
                break;
            }
            if (symbol == 'f') {
                pollinatedFlowers++;
            }
            if (symbol == 'O') {
                continue;
            }
            command = scan.nextLine();
        }
        if (isOutside) {
            System.out.println("The bee got lost!");
        } else {
            matrix[beeRow][beeCol] = 'B';
        }
        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n",
                    5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n",pollinatedFlowers);
        }
        print(matrix);
    }

    private static void print(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
