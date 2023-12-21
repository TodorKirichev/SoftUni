package TextProcessingLab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] bannedWords = scan.nextLine().split(", ");
        String text = scan.nextLine();

        for (String word : bannedWords) {
          String replacement = replacement(word);
          text = text.replace(word,replacement);
        }
        System.out.println(text);
    }

    private static String replacement(String word) {
        String replacement = "";
        for (int i = 0; i < word.length(); i++) {
            replacement += "*";
        }
        return replacement;
    }
}
