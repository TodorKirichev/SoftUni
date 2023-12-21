package ProgrammingFundamentalsMidExamRetake_3;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int energy = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();
        int countWon = 0;

        while (!command.equals("End of battle") && energy >= 0){

            int distance = Integer.parseInt(command);

            if (energy < distance) {
                System.out.printf("Not enough energy!" +
                        " Game ends with %d won battles and %d energy",countWon,energy);
                return;
            }else{
                energy -= distance;
                countWon++;
                if (countWon % 3 == 0) {
                    energy += countWon;
                }
            }

            command = scan.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d",countWon,energy);
    }
}
