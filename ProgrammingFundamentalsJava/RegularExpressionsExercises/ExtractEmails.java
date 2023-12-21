package RegularExpressionsExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\w+[\\.-\\_]?\\w+@[A-Za-z]+\\-?[A-Za-z]+\\.[A-Za-z]+\\-?[A-Za-z]+(\\.[A-Za-z]+\\-?[A-Za-z]+)*");

        String input = scan.nextLine();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
