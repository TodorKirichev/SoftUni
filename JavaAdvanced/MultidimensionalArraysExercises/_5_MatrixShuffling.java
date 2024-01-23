package JavaAdvanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class _5_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt();
        int col = scan.nextInt();
        scan.nextLine();
        String[][] matrix = new String[row][col];

        readMatrix(scan, matrix);
        while (true) {
            String input = scan.nextLine();
            if (input.equals("END")) {
                break;
            }
            String[] commandParts = input.split(" ");
            if (validate(commandParts,matrix)) {
                int index1 = Integer.parseInt(commandParts[1]);
                int index2 = Integer.parseInt(commandParts[2]);
                int index3 = Integer.parseInt(commandParts[3]);
                int index4 = Integer.parseInt(commandParts[4]);
                String firstElement = matrix[index1][index2];
                String secondElement = matrix[index3][index4];
                matrix[index1][index2] = secondElement;
                matrix[index3][index4] = firstElement;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            System.out.println(String.join(" ",strings));
        }
    }

    private static boolean validate(String[] commandParts,String[][] matrix) {
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        if (commandParts.length != 5) {
            return false;
        }
        for (int i = 1; i < commandParts.length; i++) {
            int index = Integer.parseInt(commandParts[i]);
            if (i % 2 != 0) {
                if (index < 0 || index > matrix.length - 1) {
                    return false;
                }
            } else {
                if (index < 0 || index > matrix[0].length - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void readMatrix(Scanner scan, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scan.nextLine().split(" ");
        }
    }
}
