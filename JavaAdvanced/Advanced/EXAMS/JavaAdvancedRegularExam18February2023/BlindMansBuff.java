package Advanced.EXAMS.JavaAdvancedRegularExam18February2023;

import java.util.Scanner;

import static java.lang.System.in;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        char[][] matrix = new char[rows][cols];
        int blindManRow = 0;
        int blindManCol = 0;
        int numOfOpponents = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] line = scan.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
                if (matrix[i][j] == 'B') {
                    blindManRow = i;
                    blindManCol = j;
                }
                if (matrix[i][j] == 'P') {
                    numOfOpponents++;
                }
            }
        }
        int touchedOpponents = 0;
        int moves = 0;

        while (true) {
            String command = scan.nextLine();
            if (command.equals("Finish")) {
                break;
            }
            boolean isLegalMove = false;
            switch (command) {
                case "up":
                    if (blindManRow > 0 && matrix[blindManRow - 1][blindManCol] != 'O') {
                        blindManRow--;
                        isLegalMove = true;
                    }
                    break;
                case "down":
                    if (blindManRow < matrix.length - 1 && matrix[blindManRow + 1][blindManCol] != 'O') {
                        blindManRow++;
                        isLegalMove = true;
                    }
                    break;
                case "left":
                    if (blindManCol > 0 && matrix[blindManRow][blindManCol - 1] != 'O') {
                        blindManCol--;
                        isLegalMove = true;
                    }
                    break;
                case "right":
                    if (blindManCol < matrix[0].length - 1 && matrix[blindManRow][blindManCol + 1] != 'O') {
                        blindManCol++;
                        isLegalMove = true;
                    }
                    break;
            }
            if (isLegalMove) {
                moves++;
                char symbol = matrix[blindManRow][blindManCol];
                if (symbol == 'P') {
                    touchedOpponents++;
                    matrix[blindManRow][blindManCol] = '-';
                }
            }
            if (numOfOpponents == touchedOpponents) {
                break;
            }
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d\n",touchedOpponents,moves);
    }
}
