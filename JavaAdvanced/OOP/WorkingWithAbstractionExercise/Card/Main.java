package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise.Card;

import SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise.Card.CardRank;
import SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise.Card.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rank = scan.nextLine();
        String suit = scan.nextLine();
        Card card = new Card(rank,suit);

        System.out.printf("Card name: %s of %s; Card power: %d\n",card.rank(),card.suit(),card.getPower());

    }
}
