package FINALEXAM;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Second {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("[@#]+(?<color>[a-z]{3,})[@#]+[^0-9A-Za-z]*/+(?<amount>[0-9]+)/+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String color = matcher.group("color");
            int amount = Integer.parseInt(matcher.group("amount"));
            System.out.printf("You found %d %s eggs!\n",amount,color);
        }
    }
}
