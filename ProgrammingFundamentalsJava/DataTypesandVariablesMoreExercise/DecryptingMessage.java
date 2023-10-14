package DataTypesandVariablesMoreExercise;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int key = Integer.parseInt(scan.nextLine());
        int lines = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < lines; i++) {
            char symbol = scan.nextLine().charAt(0);
            System.out.print((char)(symbol + key));
        }
    }
}
