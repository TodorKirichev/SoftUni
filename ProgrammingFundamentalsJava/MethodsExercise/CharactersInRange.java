package MethodsExercise;

import java.util.Scanner;

import static java.lang.System.in;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        char firstChar = scan.nextLine().charAt(0);
        char secondChar = scan.nextLine().charAt(0);

        printBetween(firstChar,secondChar);

    }
    public static void printBetween(char firstChar,char secondChar) {
        if (firstChar < secondChar) {
            for (int symbol = firstChar + 1; symbol < secondChar; symbol++) {

                System.out.print((char)symbol + " ");
            }
        } else {
            for (int symbol = secondChar + 1; symbol < firstChar; symbol++) {

                System.out.print((char)symbol + " ");
            }
        }
    }
}
