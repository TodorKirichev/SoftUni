package Exams.EXAMS.JavaAdvancedRetakeExam18August2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int row = scan.nextInt();
        int col = scan.nextInt();
        scan.nextLine();

        char[][] matrix = new char[row][col];

        int playerRow = 0;
        int playerCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
                if (matrix[i][j] == 'Y') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        List<String> path = new ArrayList<>();

        String command = scan.nextLine();
        while (!command.equals("Finish")) {

            switch (command) {
                case "up":
                    if (playerRow - 1 >= 0 && matrix[playerRow - 1][playerCol] != 'T') {
                        playerRow--;
                        path.add(command);
                    }
                    break;
                case "down":
                    if (playerRow + 1 < matrix.length && matrix[playerRow + 1][playerCol] != 'T') {
                        playerRow++;
                        path.add(command);
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0 && matrix[playerRow][playerCol - 1] != 'T') {
                        playerCol--;
                        path.add(command);
                    }
                    break;
                case "right":
                    if (playerCol + 1 < matrix[0].length && matrix[playerRow][playerCol + 1] != 'T') {
                        playerCol++;
                        path.add(command);
                    }
                    break;
            }
            command = scan.nextLine();
        }
        if (matrix[playerRow][playerCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s", String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }
    }
}
