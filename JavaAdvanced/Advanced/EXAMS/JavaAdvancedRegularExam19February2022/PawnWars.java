package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam19February2022;

import java.util.Scanner;

import static java.lang.System.in;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int whiteRow = 0;
        int whiteCol = 0;

        int blackRow = 0;
        int blackCol = 0;

        char[][] matrix = new char[8][8];

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            matrix[i] = new char[line.length()];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'w') {
                    whiteRow = i;
                    whiteCol = j;
                }
                if (matrix[i][j] == 'b') {
                    blackRow = i;
                    blackCol = j;
                }
            }
        }
        while (true) {
            matrix[whiteRow][whiteCol] = '-';

            if (matrix[whiteRow - 1][Math.max(whiteCol - 1,0)] == 'b') {
                System.out.printf("Game over! White capture on %c%d.\n",97 + whiteCol - 1,matrix.length - whiteRow + 1);
                break;
            } else if (matrix[whiteRow - 1][Math.min(whiteCol + 1,matrix[0].length - 1)] == 'b') {
                System.out.printf("Game over! White capture on %c%d.\n",97 + whiteCol + 1,matrix.length - whiteRow + 1);
                break;
            } else {
                whiteRow --;
                matrix[whiteRow][whiteCol] = 'w';
            }
            if (whiteRow == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %c%d.\n",97 + whiteCol,matrix.length - whiteRow);
                break;
            }
            if (matrix[blackRow + 1][Math.max(blackCol - 1,0)] == 'w') {
                System.out.printf("Game over! Black capture on %c%d.\n",97 + blackCol - 1,matrix.length - blackRow - 1);
                break;
            } else if (matrix[blackRow + 1][Math.min(blackCol + 1,matrix[0].length - 1)] == 'w') {
                System.out.printf("Game over! Black capture on %c%d.\n",97 + blackCol + 1,matrix.length - blackRow - 1);
                break;
            } else {
                blackRow++;
                matrix[blackRow][blackCol] = 'b';
            }
            if (blackRow == 7) {
                System.out.printf("Game over! Black pawn is promoted to a queen at %c%d.\n",97 + blackCol,matrix.length - blackRow);
                break;
            }
        }
    }
}
