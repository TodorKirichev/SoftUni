package TextProcessingMoreExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Character> morseCode = new HashMap<>();
        morseCode.put(".-", 'A');
        morseCode.put("-...", 'B');
        morseCode.put("-.-.", 'C');
        morseCode.put("-..", 'D');
        morseCode.put(".", 'E');
        morseCode.put("..-.", 'F');
        morseCode.put("--.", 'G');
        morseCode.put("....", 'H');
        morseCode.put("..", 'I');
        morseCode.put(".---", 'J');
        morseCode.put("-.-", 'K');
        morseCode.put(".-..", 'L');
        morseCode.put("--", 'M');
        morseCode.put("-.", 'N');
        morseCode.put("---", 'O');
        morseCode.put(".--.", 'P');
        morseCode.put("--.-", 'Q');
        morseCode.put(".-.", 'R');
        morseCode.put("...", 'S');
        morseCode.put("-", 'T');
        morseCode.put("..-", 'U');
        morseCode.put("...-", 'V');
        morseCode.put(".--", 'W');
        morseCode.put("-..-", 'X');
        morseCode.put("-.--", 'Y');
        morseCode.put("--..", 'Z');

        StringBuilder decryptedMessage = new StringBuilder();

        String[] message = scan.nextLine().split("\\|");
        for (String word : message) {
            String[] letters = word.trim().split(" ");
            for (String symbol : letters) {
                char ch = morseCode.get(symbol);
                decryptedMessage.append(ch);
            }
            decryptedMessage.append(" ");
        }
        System.out.println(decryptedMessage);
    }
}
