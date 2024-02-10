package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise._5_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Galaxy {
    private int[][] matrix;
    private Evil evil;
    private Jedi jedi;

    public Galaxy(Scanner scan) {
        this.matrix = getMatrix(scan);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Evil getEvil() {
        return evil;
    }

    public void setEvil(Evil evil) {
        this.evil = evil;
    }

    public Jedi getJedi() {
        return jedi;
    }

    public void setJedi(Jedi jedi) {
        this.jedi = jedi;
    }

    private int[][] getMatrix(Scanner scan) {
        int[] dimensions = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = dimensions[0];
        int col = dimensions[1];

        int[][] matrix = new int[row][col];
        fillMatrix(row, col, matrix);
        return matrix;
    }
    private void fillMatrix(int row, int col, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
    }
    public void moveEvil() {

        while (evil.getRow() >= 0 && evil.getCol() >= 0) {
            if (evil.getRow() < matrix.length && evil.getCol() < matrix[0].length) {
                matrix[evil.getRow()][evil.getCol()] = 0;
            }
            evil.setRow(evil.getRow() - 1);
            evil.setCol(evil.getCol() - 1);
        }
    }
    public long moveJedi() {
        long sum = 0;
        while (jedi.getRow() >= 0 && jedi.getCol() < matrix[1].length) {
            if (jedi.getRow() >= 0 && jedi.getRow() < matrix.length && jedi.getCol() >= 0 && jedi.getCol() < matrix[0].length) {
                sum += matrix[jedi.getRow()][jedi.getCol()];
            }

            jedi.setCol(jedi.getCol() + 1);
            jedi.setRow(jedi.getRow() - 1);
        }
        return sum;
    }
}
