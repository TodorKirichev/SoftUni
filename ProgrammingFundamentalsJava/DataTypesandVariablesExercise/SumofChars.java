package DataTypesandVariablesExercise;

import java.util.Scanner;

public class SumofChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lines = Integer.parseInt(scan.nextLine());
        int sum = 0;

        for (int i = 0; i < lines; i++) {
            char letter = scan.nextLine().charAt(0);
            sum+=letter;
        }
        System.out.printf("The sum equals: %d",sum);
    }
}
