package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise.Card;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = CardRank.valueOf(cardRank);
        this.cardSuit = CardSuit.valueOf(cardSuit);
    }

    public int getPower() {
        return this.cardRank.getPower() + this.cardSuit.getPower();
    }
    public String rank() {
        return cardRank.name();
    }
    public String suit() {
        return cardSuit.name();
    }
}
