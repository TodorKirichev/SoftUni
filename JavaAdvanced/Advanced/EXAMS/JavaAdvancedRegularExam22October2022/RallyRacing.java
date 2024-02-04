package Exams.EXAMS.JavaAdvancedRegularExam22October2022;

import java.util.Scanner;

import static java.lang.System.in;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int size = Integer.parseInt(scan.nextLine());
        String racingNumber = scan.nextLine();

        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String[] line = scan.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }
        int carRow = 0;
        int carCol = 0;

        int kilometersPassed = 0;

        boolean isFinished = false;

        while (true) {
            String command = scan.nextLine();
            if (command.equals("End")) {
                break;
            }
            switch (command) {
                case "up":
                    matrix[carRow][carCol] = '.';
                    carRow--;
                    if (matrix[carRow][carCol] == '.') {
                        kilometersPassed += 10;
                    } else if (matrix[carRow][carCol] == 'T') {
                        matrix[carRow][carCol] = '.';
                        for (int i = 0; i < matrix.length; i++) {
                            for (int j = 0; j < matrix[0].length; j++) {
                                if (matrix[i][j] == 'T') {
                                    carRow = i;
                                    carCol = j;
                                }
                            }
                        }
                        matrix[carRow][carCol] = '.';
                        kilometersPassed += 30;
                    } else if (matrix[carRow][carCol] == 'F') {
                        kilometersPassed += 10;
                        isFinished = true;
                    }
                    break;
                case "down":
                    matrix[carRow][carCol] = '.';
                    carRow++;
                    if (matrix[carRow][carCol] == '.') {
                        kilometersPassed += 10;
                    } else if (matrix[carRow][carCol] == 'T') {
                        matrix[carRow][carCol] = '.';
                        for (int i = 0; i < matrix.length; i++) {
                            for (int j = 0; j < matrix[0].length; j++) {
                                if (matrix[i][j] == 'T') {
                                    carRow = i;
                                    carCol = j;
                                }
                            }
                        }
                        matrix[carRow][carCol] = '.';
                        kilometersPassed += 30;
                    } else if (matrix[carRow][carCol] == 'F') {
                        kilometersPassed += 10;
                        isFinished = true;
                    }
                    break;
                case "left":
                    matrix[carRow][carCol] = '.';
                    carCol--;
                    if (matrix[carRow][carCol] == '.') {
                        kilometersPassed += 10;
                    } else if (matrix[carRow][carCol] == 'T') {
                        matrix[carRow][carCol] = '.';
                        for (int i = 0; i < matrix.length; i++) {
                            for (int j = 0; j < matrix[0].length; j++) {
                                if (matrix[i][j] == 'T') {
                                    carRow = i;
                                    carCol = j;
                                }
                            }
                        }
                        matrix[carRow][carCol] = '.';
                        kilometersPassed += 30;
                    } else if (matrix[carRow][carCol] == 'F') {
                        kilometersPassed += 10;
                        isFinished = true;
                    }
                    break;
                case "right":
                    matrix[carRow][carCol] = '.';
                    carCol++;
                    if (matrix[carRow][carCol] == '.') {
                        kilometersPassed += 10;
                    } else if (matrix[carRow][carCol] == 'T') {
                        matrix[carRow][carCol] = '.';
                        for (int i = 0; i < matrix.length; i++) {
                            for (int j = 0; j < matrix[0].length; j++) {
                                if (matrix[i][j] == 'T') {
                                    carRow = i;
                                    carCol = j;
                                }
                            }
                        }
                        matrix[carRow][carCol] = '.';
                        kilometersPassed += 30;
                    } else if (matrix[carRow][carCol] == 'F') {
                        kilometersPassed += 10;
                        isFinished = true;
                    }
                    break;
            }
            if (isFinished) {
                System.out.printf("Racing car %s finished the stage!\n",racingNumber);
                break;
            }
        }
        matrix[carRow][carCol] = 'C';
        if (!isFinished) {
            System.out.printf("Racing car %s DNF.\n",racingNumber);
        }
        System.out.printf("Distance covered %d km.\n",kilometersPassed);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
