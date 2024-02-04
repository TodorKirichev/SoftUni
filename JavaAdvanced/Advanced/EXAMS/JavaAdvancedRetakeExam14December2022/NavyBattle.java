package Exams.EXAMS.JavaAdvancedRetakeExam14December2022;

import java.util.Scanner;

import static java.lang.System.in;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int size = Integer.parseInt(scan.nextLine());
        char[][] matrix = new char[size][size];
        int subRows = 0;
        int subCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'S') {
                    subRows = i;
                    subCol = j;
                }
            }
        }
        int minesHit = 0;
        int cruisersHit = 0;

        while (true) {
            String command = scan.nextLine();
            matrix[subRows][subCol] = '-';

            switch (command) {
                case "up":
                    subRows--;
                    if (matrix[subRows][subCol] == '*') {
                        minesHit++;
                    }
                    if (matrix[subRows][subCol] == 'C') {
                        cruisersHit++;
                    }
                    matrix[subRows][subCol] = '-';
                    break;
                case "down":
                    subRows++;
                    if (matrix[subRows][subCol] == '*') {
                        minesHit++;
                    }
                    if (matrix[subRows][subCol] == 'C') {
                        cruisersHit++;
                    }
                    matrix[subRows][subCol] = '-';
                    break;
                case "left":
                    subCol--;
                    if (matrix[subRows][subCol] == '*') {
                        minesHit++;
                    }
                    if (matrix[subRows][subCol] == 'C') {
                        cruisersHit++;
                    }
                    matrix[subRows][subCol] = '-';
                    break;
                case "right":
                    subCol++;
                    if (matrix[subRows][subCol] == '*') {
                        minesHit++;
                    }
                    if (matrix[subRows][subCol] == 'C') {
                        cruisersHit++;
                    }
                    matrix[subRows][subCol] = '-';
                    break;
            }
            if (minesHit == 3) {
                System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n",subRows,subCol);
                matrix[subRows][subCol] = 'S';
                break;
            }
            if (cruisersHit == 3) {
                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                matrix[subRows][subCol] = 'S';
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
