package JavaAdvanced.MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class _7_Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(rows, matrix, cols);

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Nuke it from orbit")) {
                break;
            }
            String[] commandParts = input.split(" ");
            int indexRow = Integer.parseInt(commandParts[0]);
            int indexCol = Integer.parseInt(commandParts[1]);
            int radius = Integer.parseInt(commandParts[2]);

            modifyMatrix(indexRow, radius, indexCol, matrix);
        }
        printMatrix(matrix);
    }

    private static void modifyMatrix(int indexRow, int radius, int indexCol, List<List<Integer>> matrix) {
        for (int i = indexRow - radius; i <= indexRow + radius; i++) {
            if (isValid(i, indexCol, matrix) && i != indexRow) {
                matrix.get(i).remove(indexCol);
            }
        }
        for (int i = indexCol + radius; i >= indexCol - radius; i--) {
            if (isValid(indexRow,i, matrix)) {
                matrix.get(indexRow).remove(i);
            }
        }
        matrix.removeIf(List::isEmpty);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int i, int indexCol, List<List<Integer>> matrix) {
        return i >= 0 && i < matrix.size() && indexCol >= 0 && indexCol < matrix.get(i).size();
    }

    private static void fillMatrix(int rows, List<List<Integer>> matrix, int cols) {
        int counter = 1;
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(counter++);
            }
        }
    }
}