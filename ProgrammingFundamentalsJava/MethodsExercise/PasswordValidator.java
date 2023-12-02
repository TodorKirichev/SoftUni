package MethodsExercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String password = scan.nextLine();

        if (checkLength(password) && checkLettersAndDigits(password) && check2Digits(password)) {
            System.out.println("Password is valid");
        } else {
            if (!checkLength(password)) {
                System.out.println("Password must be between 6 and 10 characters");
            }
            if (!checkLettersAndDigits(password)) {
                System.out.println("Password must consist only of letters and digits");
            }
            if (!check2Digits(password)) {
                System.out.println("Password must have at least 2 digits");
            }
        }



    }
    public static boolean checkLength(String password) {
         if (password.length() >= 6 && password.length() <= 10) {
             return true;
         } else {
             return false;
         }
    }
    public static boolean checkLettersAndDigits(String password) {
        boolean isTrue = true;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (symbol >= 48 && symbol <= 57
                    || symbol >= 65 && symbol <= 90
                    || symbol >= 97 && symbol <= 122) {
            } else {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }
    public static boolean check2Digits(String password) {
        boolean isTrue = false;
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            if (symbol >= 48 && symbol <= 57) {
                counter++;
            }
        }
        if (counter >= 2) {
            isTrue = true;
        }
        return isTrue;
    }
}
