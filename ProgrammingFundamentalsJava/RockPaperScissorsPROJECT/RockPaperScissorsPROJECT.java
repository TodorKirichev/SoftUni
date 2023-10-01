package DataTypesandVariablesExercise;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsPROJECT {
    private static final String rock = "Rock";
    private static final String paper = "Paper";
    private static final String scissors = "Scissors";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Choose rock ,paper or scissors: ");
        String playerMove = scan.nextLine();

        switch (playerMove){
            case "r":
            case "rock":
                playerMove = rock;
                break;
            case "p":
            case "paper":
                playerMove = paper;
                break;
            case "s":
            case "scissors":
                playerMove = scissors;
                break;
            default:
                System.out.println("Invalid input. Try again...");
                break;
        }
        Random random = new Random();
        int computerChoice = random.nextInt(4);
        String computerMove = "";

        switch (computerChoice){
            case 1:
                computerMove = rock;
                break;
            case 2:
                computerMove = paper;
                break;
            case 3:
                computerMove = scissors;
                break;
        }
        if ((playerMove.equals(rock) && computerMove.equals(scissors)) ||
        (playerMove.equals(paper) && computerMove.equals(rock)) ||
                (playerMove.equals(scissors) && computerMove.equals(paper))){
            System.out.println("You win.");
        } else if ((playerMove.equals(rock) && computerMove.equals(paper)) ||
                (playerMove.equals(paper) && computerMove.equals(scissors)) ||
                (playerMove.equals(scissors) && computerMove.equals(rock))) {
            System.out.println("You lose.");
        } else {
            System.out.println("This game was a draw.");
        }
    }
}
