package GuessANumberPROJECT;

import java.util.Random;
import java.util.Scanner;

public class GuessANumberPROJECT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Random random = new Random();
        int computerChoice = random.nextInt(100);

        while (true){
            System.out.print("Guess a number (1-100) :");

            String playerChoice = scan.nextLine();
            boolean isValid = true;

            for (int i = 0; i < playerChoice.length(); i++) {

                int symbol = playerChoice.charAt(i);

                if (symbol < 48 || symbol > 57) {
                    isValid = false;
                }
            }
            if (isValid) {
                if (Integer.parseInt(playerChoice) == computerChoice) {
                    System.out.println("You guessed it!");
                    break;
                } else if (Integer.parseInt(playerChoice) > computerChoice) {
                    System.out.println("Too High");
                }else {
                    System.out.println("Too Low");
                }
            } else {
                System.out.println("Invalid input.");
            }
        }
    }
}
