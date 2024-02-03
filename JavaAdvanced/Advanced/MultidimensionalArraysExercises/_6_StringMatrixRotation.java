package JavaAdvanced.MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _6_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] commandParts = scan.nextLine().split("[()]");
        int rotation = Integer.parseInt(commandParts[1]) % 360;
        
        List<String> words = new ArrayList<>();
        fillWords(scan, words);

        int rows = words.size();
        int cols = words.stream().map(String::length).max(Integer::compareTo).get();
        char[][] matrix = new char[rows][cols];
        fillMatrix(words, rows, cols, matrix);


        switch (rotation) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0 ; row--) {
                    for (int col = cols - 1; col >= 0 ; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0 ; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }

    private static void fillMatrix(List<String> words, int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String word = words.get(row);
            for (int col = 0; col < cols; col++) {
                if (col <= word.length() - 1) {
                    matrix[row][col] = word.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static void fillWords(Scanner scan, List<String> words) {
        while (true) {
            String input = scan.nextLine();
            if (input.equals("END")) {
                break;
            }
            words.add(input);
        }
    }
}
