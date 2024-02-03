package JavaAdvanced.MultidimensionalArraysExercises;

import java.util.Scanner;

public class _9_ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt();
        int col = scan.nextInt();
        scan.nextLine();

        boolean[][] matrix = new boolean[row][col];

        fillMatrix(matrix);
        boolean isFull = false;

        while (true) {
            String input = scan.nextLine();
            if (input.equals("stop")) {
                break;
            }
            String[] inputParts = input.split("\\s+");
            int z = Integer.parseInt(inputParts[0]);
            int x = Integer.parseInt(inputParts[1]);
            int y = Integer.parseInt(inputParts[2]);

            int distance = 1;
            if (!matrix[x][y]) {
                matrix[x][y] = true;
                distance += Math.abs(x - z) + y;
            } else {
                int searchLeft = y - 1;
                int searchRight = y + 1;
                while (searchLeft > 0 && searchRight < matrix[x].length) {
                    if (!matrix[x][searchLeft]) {
                        matrix[x][searchLeft] = true;
                        distance += Math.abs(x - z) + searchLeft;
                        break;
                    } else if (!matrix[x][searchRight]){
                        matrix[x][searchRight] = true;
                        searchRight++;
                        distance += Math.abs(x - z) + searchRight;
                        break;
                    } else {
                        System.out.printf("Row %d full\n",x);
                        isFull = true;
                    }
                    searchLeft--;
                    searchRight++;
                }
            }
            if (isFull) {
                continue;
            }
            System.out.println(distance);
        }
    }

    private static void fillMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = false;
            }
        }
    }
}
