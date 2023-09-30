package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String actorName = scan.nextLine();
        double pointFromAcademy = Double.parseDouble(scan.nextLine());
        int numJudges = Integer.parseInt(scan.nextLine());
        double actorPoints = pointFromAcademy;

        for (int i = 0; i < numJudges; i++) {

            String judgeName = scan.nextLine();
            double judgePoints = Double.parseDouble(scan.nextLine());

            actorPoints+=judgeName.length()*judgePoints/2;
            if (actorPoints>=1250.5){
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!",actorName,actorPoints);
                return;
            }
        }
        System.out.printf("Sorry, %s you need %.1f more!",actorName,1250.5-actorPoints);
    }
}
