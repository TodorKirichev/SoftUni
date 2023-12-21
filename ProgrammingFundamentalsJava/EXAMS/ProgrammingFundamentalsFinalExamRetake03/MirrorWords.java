package ProgrammingFundamentalsFinalExamRetake03;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        Map<String,String> mirrorWords = new LinkedHashMap<>();
        int validPairs = 0;
        while (matcher.find()) {
            validPairs++;
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            StringBuilder reversedSecondWord = new StringBuilder(secondWord).reverse();
            if (firstWord.contentEquals(reversedSecondWord)) {
                mirrorWords.put(firstWord,secondWord);
            }
        }
        if (validPairs > 0) {

            System.out.printf("%d word pairs found!\n",validPairs);

        } else {
            System.out.println("No word pairs found!");
        }
        if (!mirrorWords.isEmpty()) {
            List<String> mirrors = new ArrayList<>();
            System.out.println("The mirror words are:");
            for (Map.Entry <String,String> entry : mirrorWords.entrySet()) {
                String first = entry.getKey();
                String second = entry.getValue();
                mirrors.add(first + " <=> " + second);
            }
            System.out.print(String.join(", ",mirrors));
            System.out.println();
        } else {
            System.out.println("No mirror words!");
        }
    }
}
