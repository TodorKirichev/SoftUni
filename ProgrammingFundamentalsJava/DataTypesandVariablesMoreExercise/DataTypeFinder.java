package DataTypesandVariablesMoreExercise;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        while (!input.equals("END")) {

            String type = "";

            if (input.equalsIgnoreCase("true") ||
                    input.equalsIgnoreCase("false")) {
                type = "boolean";
            } else if (input.length() == 1) {
                char symbol = input.charAt(0);
                if (symbol < 48 || symbol > 57) {
                    type = "character";
                }else {
                    type = "integer";
                }
            } else {
                boolean isString = false;
                boolean isFloat = false;

                for (int i = 0; i < input.length(); i++) {
                    char symbol = input.charAt(i);
                    if (symbol < 45 || symbol > 57) {
                        isString = true;
                    }
                    if (symbol == 46) {
                        isFloat = true;
                    }
                }
                if (isString) {
                    type = "string";
                }else {
                    if (isFloat){
                        type = "floating point";
                    }else {
                        type = "integer";
                    }
                }
            }
            System.out.printf("%s is %s type%n", input, type);
            input= scan.nextLine();
        }
    }
}
