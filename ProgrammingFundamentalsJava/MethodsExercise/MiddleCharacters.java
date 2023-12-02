package MethodsExercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        printMidCharacters(text);
    }
    public static void printMidCharacters(String text) {
        if (text.length() % 2 == 0) {
            char mid1 = text.charAt(text.length() / 2 - 1);
            char mid2 = text.charAt(text.length() / 2);
            System.out.printf("%s%s",mid1,mid2);
        } else {
            char mid = text.charAt(text.length() / 2);
            System.out.printf("%s",mid);
        }
    }
}
