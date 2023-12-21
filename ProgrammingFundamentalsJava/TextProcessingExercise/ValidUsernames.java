package TextProcessingExercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] usernames = scan.nextLine().split(", ");

        isValid(usernames);
    }

    private static void isValid(String[] usernames) {
        for (String name : usernames) {
            if (name.length() > 3 && name.length() < 16) {
                boolean isValid = true;
                for (int i = 0; i < name.length(); i++) {
                    char c = name.charAt(i);
                    if (!(Character.isLetterOrDigit(c) || c == '-' || c == '_')) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    System.out.println(name);
                }
            }
        }
    }
}
