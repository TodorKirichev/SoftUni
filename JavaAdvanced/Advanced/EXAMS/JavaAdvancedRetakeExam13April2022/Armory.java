package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam13April2022;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];

        int officerRow = 0;
        int officerCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'A') {
                    officerRow = i;
                    officerCol = j;
                }
            }
        }
        int goldCoins = 0;
        boolean isOutside = false;

        while (goldCoins < 65 && !isOutside) {
            String command = scan.nextLine();
            boolean isSwords = false;
            boolean isMirror = false;

            switch (command) {
                case "up":
                    if (officerRow - 1 >= 0) {
                        matrix[officerRow][officerCol] = '-';
                        officerRow--;
                    } else {
                        isOutside = true;
                    }
                    break;
                case "down":
                    if (officerRow + 1 < matrix.length) {
                        matrix[officerRow][officerCol] = '-';
                        officerRow++;
                    } else {
                        isOutside = true;
                    }
                    break;
                case "left":
                    if (officerCol - 1 >= 0) {
                        matrix[officerRow][officerCol] = '-';
                        officerCol--;
                    } else {
                        isOutside = true;
                    }
                    break;
                case "right":
                    if (officerCol + 1 < matrix[0].length) {
                        matrix[officerRow][officerCol] = '-';
                        officerCol++;
                    } else {
                        isOutside = true;
                    }
                    break;
            }
            if (Character.isDigit(matrix[officerRow][officerCol])) {
                isSwords = true;
            }
            if (matrix[officerRow][officerCol] == 'M') {
                isMirror = true;
            }
            if (isSwords) {
                goldCoins += Integer.parseInt(String.valueOf(matrix[officerRow][officerCol]));
            }
            matrix[officerRow][officerCol] = '-';
            if (isMirror) {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (matrix[i][j] == 'M') {
                            officerRow = i;
                            officerCol = j;
                        }
                    }
                }
                matrix[officerRow][officerCol] = '-';
            }
        }
        if (isOutside) {
            System.out.println("I do not need more swords!");
        }
        if (goldCoins >= 65) {
            matrix[officerRow][officerCol] = 'A';
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.\n",goldCoins);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
