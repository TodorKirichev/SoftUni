package BasicSyntaxConditionalStatementsandLoopsMoreExercise;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        String word = "";

        for (int i = 0; i <text.length() ; i++) {
            char symbol = text.charAt(i);
            word=symbol+word;
        }
        System.out.println(word);
    }
}
