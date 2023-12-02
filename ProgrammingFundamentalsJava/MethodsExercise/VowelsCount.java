package MethodsExercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine().toLowerCase();

        printCountVowels(text);
    }
    public static void printCountVowels(String text) {
        int countVowels = 0;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            switch (symbol){
                case 'a':
                case 'o':
                case 'e':
                case 'i':
                case 'u':
                    countVowels++;
                    break;
            }
        }
        System.out.println(countVowels);
    }
}
