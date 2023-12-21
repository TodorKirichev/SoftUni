package TextProcessingExercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        StringBuilder encrypt = new StringBuilder();

        for (char c : text.toCharArray()) {
            encrypt.append((char)(c + 3));
        }
        System.out.println(encrypt);
    }
}
