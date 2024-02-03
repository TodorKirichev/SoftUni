package Advanced.EXAMS.JavaAdvancedRetakeExam13December2023;

import java.util.Scanner;

import static java.lang.System.in;

public class TheGambler {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int n = Integer.parseInt(scan.nextLine());

        String[][] board = fillBoard(n, scan);

        int[] gamblerPosition = findGamblerPosition(board);
        int gamblerAmount = 100;
        boolean bankrupt = false;
        boolean isWon = false;

        while (true) {
            String command = scan.nextLine();
            if (command.equals("end")) {
                break;
            }
            switch (command) {
                case "up" :
                    if (isValidVertical(board,gamblerPosition[0] - 1)) {
                        board[gamblerPosition[0]][gamblerPosition[1]] = "-";
                       gamblerPosition[0]--;
                    } else {
                        bankrupt = true;
                    }
                    if (board[gamblerPosition[0]][gamblerPosition[1]].equals("W")) {
                        gamblerAmount += 100;
                    } else if (board[gamblerPosition[0]][gamblerPosition[1]].equals("P")) {
                        gamblerAmount -= 200;
                    } else if (board[gamblerPosition[0]][gamblerPosition[1]].equals("J")) {
                        gamblerAmount += 100000;
                        isWon = true;
                    }
                    break;
                case "down" :
                    if (isValidVertical(board,gamblerPosition[0] + 1)) {
                        board[gamblerPosition[0]][gamblerPosition[1]] = "-";
                        gamblerPosition[0]++;
                    } else {
                        bankrupt = true;
                    }
                    if (board[gamblerPosition[0]][gamblerPosition[1]].equals("W")) {
                        gamblerAmount += 100;
                    } else if (board[gamblerPosition[0]][gamblerPosition[1]].equals("P")) {
                        gamblerAmount -= 200;
                    } else if (board[gamblerPosition[0]][gamblerPosition[1]].equals("J")) {
                        gamblerAmount += 100000;
                        isWon = true;
                    }
                    break;
                case "left" :
                    if (isValidHorizontal(board,gamblerPosition[1] - 1)) {
                        board[gamblerPosition[0]][gamblerPosition[1]] = "-";
                        gamblerPosition[1]--;
                    } else {
                        bankrupt = true;
                    }
                    if (board[gamblerPosition[0]][gamblerPosition[1]].equals("W")) {
                        gamblerAmount += 100;
                    } else if (board[gamblerPosition[0]][gamblerPosition[1]].equals("P")) {
                        gamblerAmount -= 200;
                    } else if (board[gamblerPosition[0]][gamblerPosition[1]].equals("J")) {
                        gamblerAmount += 100000;
                        isWon = true;
                    }
                    break;
                case "right" :
                    if (isValidHorizontal(board,gamblerPosition[1] + 1)) {
                        board[gamblerPosition[0]][gamblerPosition[1]] = "-";
                        gamblerPosition[1]++;
                    } else {
                        bankrupt = true;
                    }
                    if (board[gamblerPosition[0]][gamblerPosition[1]].equals("W")) {
                        gamblerAmount += 100;
                    } else if (board[gamblerPosition[0]][gamblerPosition[1]].equals("P")) {
                        gamblerAmount -= 200;
                    } else if (board[gamblerPosition[0]][gamblerPosition[1]].equals("J")) {
                        gamblerAmount += 100000;
                        isWon = true;
                    }
                    break;
            }
            if (gamblerAmount <= 0) {
                bankrupt = true;
            }
            if (bankrupt) {
                break;
            }
            if (isWon) {
                break;
            }
        }
        board[gamblerPosition[0]][gamblerPosition[1]] = "G";
        if (isWon) {
            System.out.printf("You win the Jackpot!\nEnd of the game. Total amount: %d$\n",gamblerAmount);
            printBoard(board);
        } else if (bankrupt) {
            System.out.println("Game over! You lost everything!");
        } else {
            System.out.printf("End of the game. Total amount: %d$\n",gamblerAmount);
            printBoard(board);
        }
    }

    private static void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isValidVertical(String[][] board, int gamblerPosition) {
        return gamblerPosition >= 0
                && gamblerPosition < board.length;
    }
    private static boolean isValidHorizontal(String[][] board, int gamblerPosition) {
        return gamblerPosition >= 0
                && gamblerPosition < board[0].length;
    }

    private static int[] findGamblerPosition(String[][] board) {
        int[] gamblerPosition = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("G")) {
                    gamblerPosition[0] = i;
                    gamblerPosition[1] = j;
                }
            }
        }
        return gamblerPosition;
    }

    private static String[][] fillBoard(int n, Scanner scan) {
        String[][] matrix = new String[n][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split("");
        }
        return matrix;
    }
}
