package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam26Oct2019;

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scan.nextLine());
        int size = Integer.parseInt(scan.nextLine());

        int playerRow = 0;
        int playerCol = 0;

        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        String command = scan.nextLine();
        while (!"end".equals(command)) {

            boolean isOutside = false;

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
                if (text.length() > 0) {
                    text.replace(text.length() - 1,text.length(),"");
                }
            }
            if (Character.isLetter(matrix[playerRow][playerCol])) {
                text.append(matrix[playerRow][playerCol]);
                matrix[playerRow][playerCol] = '-';
            }
            command = scan.nextLine();
        }
        matrix[playerRow][playerCol] = 'P';
        System.out.println(text);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
