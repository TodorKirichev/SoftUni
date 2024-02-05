package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam25June2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];

        List<String> commands = Arrays.stream(scan.nextLine().split(",")).collect(Collectors.toList());
        int thieveRow = 0;
        int thieveCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
                if (matrix[i][j] == 'D') {
                    thieveRow = i;
                    thieveCol = j;
                }
            }
        }
        int totalStolenMoney = 0;

        for (String command : commands) {
            boolean isOutside = false;
            int stolenMoney = 0;

            switch (command) {
                case "up":
                    if (thieveRow - 1 < 0) {
                        isOutside = true;
                    } else {
                        matrix[thieveRow][thieveCol] = '+';
                        thieveRow--;
                    }
                    break;
                case "down":
                    if (thieveRow + 1 >= matrix.length) {
                        isOutside = true;
                    } else {
                        matrix[thieveRow][thieveCol] = '+';
                        thieveRow++;
                    }
                    break;
                case "left":
                    if (thieveCol - 1 < 0) {
                        isOutside = true;
                    } else {
                        matrix[thieveRow][thieveCol] = '+';
                        thieveCol--;
                    }
                    break;
                case "right":
                    if (thieveCol + 1 >= matrix[0].length) {
                        isOutside = true;
                    } else {
                        matrix[thieveRow][thieveCol] = '+';
                        thieveCol++;
                    }
                    break;
            }
            if (matrix[thieveRow][thieveCol] == '$') {
                matrix[thieveRow][thieveCol] = '+';
                stolenMoney = thieveRow * thieveCol;
                totalStolenMoney += stolenMoney;
                System.out.printf("You successfully stole %d$.\n",stolenMoney);
            }
            if (matrix[thieveRow][thieveCol] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.\n",totalStolenMoney);
                matrix[thieveRow][thieveCol] = '#';
                printMatrix(matrix);
                return;
            }
            if (isOutside) {
                System.out.println("You cannot leave the town, there is police outside!");
            }
        }
        matrix[thieveRow][thieveCol] = 'D';
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n",totalStolenMoney);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
