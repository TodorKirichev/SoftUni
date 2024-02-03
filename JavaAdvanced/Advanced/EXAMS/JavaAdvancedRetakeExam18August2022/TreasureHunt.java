package Advanced.EXAMS.JavaAdvancedRetakeExam18August2022;

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
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = line[j].charAt(0);
                if (matrix[i][j] == 'Y') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        boolean isTreasureFound = false;
        List<String> path = new ArrayList<>();

        String command = scan.nextLine();
        while (!command.equals("Finish")) {

            switch (command) {
                case "up":
                    if (playerRow - 1 < 0) {
                        playerRow = 0;
                    } else {
                        if (matrix[playerRow - 1][playerCol] != 'T') {
                            playerRow--;
                            path.add(command);
                            if (matrix[playerRow][playerCol] == 'X') {
                                isTreasureFound = true;
                            }
                        }
                    }
                    break;
                case "down":
                    if (playerRow + 1 > matrix.length - 1) {
                        playerRow = matrix.length - 1;
                    } else {
                        if (matrix[playerRow + 1][playerCol] != 'T') {
                            playerRow++;
                            path.add(command);
                            if (matrix[playerRow][playerCol] == 'X') {
                                isTreasureFound = true;
                            }
                        }
                    }
                    break;
                case "left":
                    if (playerCol - 1 < 0) {
                        playerCol = 0;
                    } else {
                        if (matrix[playerRow][playerCol - 1] != 'T') {
                            playerCol--;
                            path.add(command);
                            if (matrix[playerRow][playerCol] == 'X') {
                                isTreasureFound = true;
                            }
                        }
                    }
                    break;
                case "right":
                    if (playerCol + 1 > matrix[0].length - 1) {
                        playerCol = matrix[0].length - 1;
                    } else {
                        if (matrix[playerRow][playerCol + 1] != 'T') {
                            playerCol++;
                            path.add(command);
                            if (matrix[playerRow][playerCol] == 'X') {
                                isTreasureFound = true;
                            }
                        }
                    }
                    break;
            }
            if (isTreasureFound) {
                System.out.println("I've found the treasure!");
                System.out.printf("The right path is %s\n", String.join(", ", path));
            }
            command = scan.nextLine();
        }
        if (!isTreasureFound){
            System.out.println("The map is fake!");
        }
    }

    private static boolean isOnRow(char[][] matrix, int i) {
        return i >= 0 && i < matrix.length;
    }
}
