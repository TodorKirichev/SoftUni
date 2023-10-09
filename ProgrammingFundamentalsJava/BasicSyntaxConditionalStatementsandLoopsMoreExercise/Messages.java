package BasicSyntaxConditionalStatementsandLoopsMoreExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < lines; i++) {
            int input = Integer.parseInt(scan.nextLine());
            int mainDigit = input % 10;
            int length = Integer.toString(input).length();

            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offset++;
            }
            int index = offset + length - 1;
            if (input == 0) {
                System.out.print(" ");
            } else {
                System.out.print((char)(index + 97));
            }
        }
    }
}
