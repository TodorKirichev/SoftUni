package SoftUni.ProgrammingFundamentalsJava.RegularExpressionsLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String phones = scan.nextLine();

        Pattern pattern = Pattern.compile("\\+359([ |-])2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = pattern.matcher(phones);

        List<String> phoneNumbers = new ArrayList<>();

        while (matcher.find()) {
            phoneNumbers.add(matcher.group());
        }
        System.out.println(String.join(", ",phoneNumbers));
    }
}