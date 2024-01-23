package JavaAdvanced.SetsAndMapsAdvancedExercises;

import java.util.*;

public class _7_HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<String>> playersScore = new LinkedHashMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("JOKER")) {
                break;
            }
            String[] inputData = input.split(":\\s+");
            String name = inputData[0];
            String[] cardList = inputData[1].split(",\\s+");

            playersScore.putIfAbsent(name,new HashSet<>());
            Set<String> cards = playersScore.get(name);

            for (String card : cardList) {
                cards.add(card);
            }
        }
        playersScore.forEach((key,value) -> {
            int score = 0;
            for (String card : value) {
                char power = card.charAt(0);
                char type = card.charAt(card.length() - 1);
                int multiplier = 0;
                switch (type) {
                    case 'S':
                        multiplier = 4;
                        break;
                    case 'H':
                        multiplier = 3;
                        break;
                    case 'D':
                        multiplier = 2;
                        break;
                    case 'C':
                        multiplier = 1;
                        break;
                }
                if (Character.isDigit(power)) {
                    if (power == 49) {
                        score += 10 * multiplier;
                    } else {
                        score += Integer.parseInt(String.valueOf(power)) * multiplier;
                    }
                } else {
                    switch (power) {
                        case 'J':
                            score += 11 * multiplier;
                            break;
                        case 'Q':
                            score += 12 * multiplier;
                            break;
                        case 'K':
                            score += 13 * multiplier;
                            break;
                        case 'A':
                            score += 14 * multiplier;
                            break;
                    }
                }
            }
            System.out.printf("%s: %d\n",key,score);
        });
    }
}
