package DataTypesandVariablesExercise;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n ; i++) {
            char first = (char) ('a' + i);
            for (int j = 0; j < n ; j++) {
                char second = (char) ('a' + j);
                for (int k = 0; k < n ; k++) {
                    char third = (char) ('a' + k);
                    System.out.printf("%c%c%c%n",first,second,third);

                }
            }
        }
    }
}
