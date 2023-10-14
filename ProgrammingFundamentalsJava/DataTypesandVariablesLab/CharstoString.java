package DataTypesandVariablesLab;

import java.util.Scanner;

public class CharstoString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = "";

        for (int i = 0; i < 3; i++) {
            char ch = scan.next().charAt(0);
            text+=ch;
        }
        System.out.println(text);
    }
}
