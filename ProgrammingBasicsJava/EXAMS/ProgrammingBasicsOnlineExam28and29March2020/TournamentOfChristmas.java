package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tournamentDays = Integer.parseInt(scan.nextLine());
        double finalProfit = 0;
        int dayWinner = 0;
        int dayLoser = 0;

        for (int i = 0; i < tournamentDays; i++) {

            int win = 0;
            int lose = 0;
            String input = scan.nextLine();
            double profit = 0;
            while (!"Finish".equals(input)) {
                String sport = input;
                String result = scan.nextLine();
                switch (result) {
                    case "win":
                        profit += 20;
                        win++;
                        break;
                    case "lose":
                        lose++;
                        break;
                }

                input = scan.nextLine();
            }
            if (win > lose) {
                profit *= 1.1;
                dayWinner++;
            } else {
                dayLoser++;
            }
            finalProfit += profit;
        }
        if (dayWinner>dayLoser){
            finalProfit*=1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f",finalProfit);
        }else {
            System.out.printf("You lost the tournament! Total raised money: %.2f",finalProfit);
        }
    }
}
