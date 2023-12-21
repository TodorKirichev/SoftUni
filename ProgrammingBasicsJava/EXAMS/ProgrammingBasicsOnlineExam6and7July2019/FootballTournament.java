package ProgrammingBasicsOnlineExam6and7July2019;

import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String clubName = scan.nextLine();
        int numMatches = Integer.parseInt(scan.nextLine());
        int countW = 0;
        int countD = 0;
        int countL = 0;
        String input = "";

        if (numMatches==0){
            System.out.printf("%s hasn't played any games during this season.",clubName);
            return;
        }

        for (int i = 0; i < numMatches; i++) {
            input = scan.nextLine();

            switch (input){
                case "W":
                    countW++;
                    break;
                case "D":
                    countD++;
                    break;
                case "L":
                    countL++;
                    break;

            }
        }
        System.out.printf("%s has won %d points during this season.%n",clubName,countW*3+countD);
        System.out.printf("Total stats:%n");
        System.out.printf("## W: %d%n",countW);
        System.out.printf("## D: %d%n",countD);
        System.out.printf("## L: %d%n",countL);
        System.out.printf("Win rate: %.2f%%%n",(double)countW/numMatches*100);
    }
}
