package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam22Feb2020;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());

        int playerRow = 0;
        int playerCol = 0;

        char[][] matrix = new char[size][size];
        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'f') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        boolean isFinished = false;
        String command = scan.nextLine();
        matrix[playerRow][playerCol] = '-';

        while (true){

            switch (command) {
                case "up":
                    if (playerRow - 1 < 0) {
                        playerRow = matrix.length - 1;
                    } else {
                        playerRow--;
                    }
                    break;
                case "down":
                    if (playerRow + 1 > matrix.length - 1) {
                        playerRow = 0;
                    } else {
                        playerRow++;
                    }
                    break;
                case "left":
                    if (playerCol - 1 < 0) {
                        playerCol = matrix[playerRow].length - 1;
                    } else {
                        playerCol--;
                    }
                    break;
                case "right":
                    if (playerCol + 1 > matrix[playerRow].length - 1) {
                        playerCol = 0;
                    } else {
                        playerCol++;
                    }
                    break;
            }
            if (matrix[playerRow][playerCol] == 'F') {
                isFinished = true;
                matrix[playerRow][playerCol] = 'f';
                break;
            }
            if (matrix[playerRow][playerCol] == 'B') {
                continue;
            }
            if (matrix[playerRow][playerCol] == 'T') {
                switch (command) {
                    case "up":
                        command = "down";
                        continue;
                    case "down":
                        command = "up";
                        continue;
                    case "left":
                        command = "right";
                        continue;
                    case "right":
                        command = "left";
                        continue;
                }
            }
            n--;
            if (n == 0) {
                break;
            }
            command = scan.nextLine();
        }
        matrix[playerRow][playerCol] = 'f';
        if (isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
