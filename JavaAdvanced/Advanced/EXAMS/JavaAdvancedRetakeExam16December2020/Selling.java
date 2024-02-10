package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam16December2020;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        char[][] bakery = new char[size][size];

        int playerRow = 0;
        int playerCol = 0;

        for (int i = 0; i < bakery.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < bakery[i].length; j++) {
                bakery[i][j] = line.charAt(j);
                if (bakery[i][j] == 'S') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }
        int price = 0;
        boolean isOutside = false;
        boolean isPriceEnough = false;
        while (true) {
            String command = scan.nextLine();
            bakery[playerRow][playerCol] = '-';

            switch (command) {
                case "up":
                    if (playerRow - 1 < 0) {
                        isOutside = true;
                    } else {
                        playerRow--;
                    }
                    break;
                case "down":
                    if (playerRow + 1 > bakery.length - 1) {
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
                    if (playerCol + 1 > bakery[playerRow].length - 1) {
                        isOutside = true;
                    } else {
                        playerCol++;
                    }
                    break;
            }
            if (isOutside) {
                break;
            }
            char symbol = bakery[playerRow][playerCol];
            if (symbol == 'O') {
                bakery[playerRow][playerCol] = '-';
                for (int i = 0; i < bakery.length; i++) {
                    for (int j = 0; j < bakery[i].length; j++) {
                        if (bakery[i][j] == 'O') {
                            playerRow = i;
                            playerCol = j;
                        }
                    }
                }
            }
            if (Character.isDigit(symbol)) {
                price += Integer.parseInt(String.valueOf(symbol));
            }
            bakery[playerRow][playerCol] = '-';
            if (price >= 50) {
                isPriceEnough = true;
                break;
            }
        }
        if (isOutside) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            bakery[playerRow][playerCol] = 'S';
        }
        if (isPriceEnough) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d\n",price);
        print(bakery);
    }

    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
