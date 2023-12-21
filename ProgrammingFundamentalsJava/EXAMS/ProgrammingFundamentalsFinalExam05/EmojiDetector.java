package ProgrammingFundamentalsFinalExam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        Pattern patternThreshold = Pattern.compile("[0-9]");
        Pattern patternEmoji = Pattern.compile("(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1");

        Matcher matcherThreshold = patternThreshold.matcher(text);
        Matcher matcherEmoji = patternEmoji.matcher(text);

        int threshold = 1;

        while (matcherThreshold.find()) {
            int digit = Integer.parseInt(matcherThreshold.group());
            threshold *= digit;
        }
        int countEmojis = 0;
        List<String> coolEmojis = new ArrayList<>();

        while (matcherEmoji.find()) {
            countEmojis++;
            String emoji = matcherEmoji.group("emoji");
            int sum = 0;
            for (char ch : emoji.toCharArray()) {
                sum += ch;
            }
            if (sum >= threshold) {
                coolEmojis.add(matcherEmoji.group());
            }
        }
        System.out.printf("Cool threshold: %d\n",threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n",countEmojis);
        coolEmojis.forEach(System.out::println);
    }
}
