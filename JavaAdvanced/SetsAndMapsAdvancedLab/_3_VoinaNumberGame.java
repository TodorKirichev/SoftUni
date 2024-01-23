package JavaAdvanced.SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _3_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstDeck = new LinkedHashSet<>();
        Set<Integer> secondDeck = new LinkedHashSet<>();
        fillDeck(scan, firstDeck);
        fillDeck(scan, secondDeck);

        for (int i = 0; i < 50; i++) {
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
            int card1 = firstDeck.iterator().next();
            firstDeck.remove(card1);
            int card2 = secondDeck.iterator().next();
            secondDeck.remove(card2);
            if (card1 > card2) {
                firstDeck.add(card1);
                firstDeck.add(card2);
            } else if (card2 > card1) {
                secondDeck.add(card1);
                secondDeck.add(card2);
            }
        }
        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static void fillDeck(Scanner scan, Set<Integer> deck) {
        String[] input = scan.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            deck.add(Integer.valueOf(input[i]));
        }
    }
}
