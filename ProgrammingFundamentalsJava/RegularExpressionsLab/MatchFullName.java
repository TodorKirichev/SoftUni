package RegularExpressionsLab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String input = scan.nextLine();

        String regex = "\\b([A-Z][a-z]+) ([A-Z][a-z]+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}