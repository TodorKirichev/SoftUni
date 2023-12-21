package RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Pattern pattern = Pattern.compile("_\\.+[A-Z][A-Za-z0-9]{4,}[A-Z]_\\.+");

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            StringBuilder sb = new StringBuilder();
            if (matcher.find()) {
                for (char ch : input.toCharArray()) {
                    if (Character.isDigit(ch)) {
                        sb.append(ch);
                    }
                }
                if (sb.length() == 0) {
                    System.out.println("Group: default");
                } else {
                    System.out.printf("Group: %s\n",sb);
                }
            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}
