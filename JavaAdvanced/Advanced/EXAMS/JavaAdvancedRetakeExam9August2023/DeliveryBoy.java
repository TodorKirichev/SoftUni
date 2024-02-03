package Advanced.EXAMS.JavaAdvancedRetakeExam9August2023;

import java.util.Scanner;

import static java.lang.System.in;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        char[][] matrix = new char[rows][cols];

        int boyRow = 0;
        int boyCol = 0;

        int restaurantRow = 0;
        int restaurantCol = 0;

        boolean isOutside = false;
        boolean isDelivered = false;

        for (int i = 0; i < rows; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < cols; j++) {
                if (line.charAt(j) == 'B') {
                    boyRow = i;
                    boyCol = j;
                }
                if (line.charAt(j) == 'P') {
                    restaurantRow = i;
                    restaurantCol = j;
                }
                matrix[i][j] = line.charAt(j);
            }
        }
        int boyStartRow = boyRow;
        int boyStartCol = boyCol;

        while (true) {
            String command = scan.nextLine();

            boolean isAtRestaurant = false;

            switch (command) {
                case "up":
                    if (isVerticalMoveLegal(matrix, boyRow - 1)) {
                        if (matrix[boyRow - 1][boyCol] != '*') {
                            boyRow -= 1;
                            if (matrix[boyRow][boyCol] == 'P') {
                                isAtRestaurant = true;
                            } else if (matrix[boyRow][boyCol] == 'A') {
                                isDelivered = true;
                            }
                            matrix[boyRow][boyCol] = '.';
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "down":
                    if (isVerticalMoveLegal(matrix, boyRow + 1)) {
                        if (matrix[boyRow + 1][boyCol] != '*') {
                            boyRow += 1;
                            if (matrix[boyRow][boyCol] == 'P') {
                                isAtRestaurant = true;
                            } else if (matrix[boyRow][boyCol] == 'A') {
                                isDelivered = true;
                            }
                            matrix[boyRow][boyCol] = '.';
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "left":
                    if (isHorizontalMoveLegal(matrix, boyCol - 1)) {
                        if (matrix[boyRow][boyCol - 1] != '*') {
                            boyCol -= 1;
                            if (matrix[boyRow][boyCol] == 'P') {
                                isAtRestaurant = true;
                            } else if (matrix[boyRow][boyCol] == 'A') {
                                isDelivered = true;
                            }
                            matrix[boyRow][boyCol] = '.';
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
                case "right":
                    if (isHorizontalMoveLegal(matrix, boyCol + 1)) {
                        if (matrix[boyRow][boyCol + 1] != '*') {
                            boyCol += 1;
                            if (matrix[boyRow][boyCol] == 'P') {
                                isAtRestaurant = true;
                            } else if (matrix[boyRow][boyCol] == 'A') {
                                isDelivered = true;
                            }
                            matrix[boyRow][boyCol] = '.';
                        }
                    } else {
                        isOutside = true;
                    }
                    break;
            }
            if (isAtRestaurant) {
                System.out.println("Pizza is collected. 10 minutes for delivery.");
                matrix[boyRow][boyCol] = 'R';
            }
            if (isOutside) {
                System.out.println("The delivery is late. Order is canceled.");
                matrix[boyStartRow][boyStartCol] = ' ';
                break;
            }
            if (isDelivered) {
                System.out.println("Pizza is delivered on time! Next order...");
                matrix[boyRow][boyCol] = 'P';
                matrix[boyStartRow][boyStartCol] = 'B';
                break;
            }
        }
        printMatrix(matrix);
    }

    private static boolean isHorizontalMoveLegal(char[][] matrix, int boyCol) {
        return boyCol >= 0 && boyCol < matrix[0].length;
    }

    private static boolean isVerticalMoveLegal(char[][] matrix, int boyRow) {
        return boyRow >= 0 && boyRow < matrix.length;
    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}





