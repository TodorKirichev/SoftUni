package TextProcessingMoreExercise;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char first = scan.nextLine().charAt(0);
        char last = scan.nextLine().charAt(0);
        StringBuilder text = new StringBuilder(scan.nextLine());

        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch > first && ch < last) {
                sum += ch;
            }
        }
        System.out.println(sum);
    }
}
