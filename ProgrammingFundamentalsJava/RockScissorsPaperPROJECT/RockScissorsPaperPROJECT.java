package RockScissorsPaperPROJECT;

import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaperPROJECT {
    private static final String rock = "Rock";
    private static final String paper = "Paper";
    private static final String scissors = "Scissors";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countPlayerScore = 0;
        int countComputerScore = 0;

        while (countPlayerScore <= 5 &&
                countComputerScore <= 5 &&
                !(countPlayerScore == 5 && countComputerScore == 5)){
            System.out.print("Choose rock ,paper or scissors: ");
            String playerMove = scan.nextLine();
            boolean isValid = true;

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
                    isValid = false;
                    break;
            }
            if (!isValid){
                continue;
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
                countPlayerScore++;
            } else if ((playerMove.equals(rock) && computerMove.equals(paper)) ||
                    (playerMove.equals(paper) && computerMove.equals(scissors)) ||
                    (playerMove.equals(scissors) && computerMove.equals(rock))) {
                System.out.println("You lose.");
                countComputerScore++;
            } else {
                    System.out.println("Draw.");
            }
        }
        if (countPlayerScore == 5 && countComputerScore == 5){
            System.out.println("This game was a draw.");
            System.out.printf("Your score: %d%nComputer score:%d%n"
            ,countPlayerScore,countComputerScore);
        } else if (countPlayerScore<countComputerScore){
            System.out.println("Computer won the game.");
            System.out.printf("Your score: %d%nComputer score:%d%n"
                    ,countPlayerScore,countComputerScore);
        } else if (countPlayerScore>countComputerScore){
            System.out.println("You won the game.");
            System.out.printf("Your score: %d%nComputer score:%d%n"
                    ,countPlayerScore,countComputerScore);
        }
    }
}