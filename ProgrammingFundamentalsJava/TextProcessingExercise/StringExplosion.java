package TextProcessingExercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scan.nextLine());
        int strength = 0;

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol == '>') {
                strength += Integer.parseInt(String.valueOf(text.charAt(i + 1)));
            } else if (strength > 0){
                text.deleteCharAt(i);
                i--;
                strength--;
            }
        }
        System.out.println(text);
    }
}
