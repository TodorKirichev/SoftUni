package MethodsExercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        while (!text.equals("END")) {

            System.out.println(checkPalindrome(text));

            text = scan.nextLine();
        }
    }
    public static boolean checkPalindrome(String text) {
        String reverse = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse += text.charAt(i);
        }
        return text.equals(reverse);
    }
}
