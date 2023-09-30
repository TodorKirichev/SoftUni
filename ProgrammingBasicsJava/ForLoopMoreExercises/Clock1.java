package ForLoopMoreExercises;

import java.util.Scanner;

public class Clock1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int hours = 0; hours < 24; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                System.out.printf("%d : %d%n",hours,minutes);
            }
        }
    }
}
