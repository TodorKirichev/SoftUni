package ConditionalStatements;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String serial = scan.nextLine();
        int durationSerial= Integer.parseInt(scan.nextLine());
        int durationBreak = Integer.parseInt(scan.nextLine());

        double timeLunch = durationBreak/8.0;
        double timeRest = durationBreak/4.0;

        if (durationBreak>=(durationSerial+timeLunch+timeRest)) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",serial,Math.ceil(durationBreak-(durationSerial+timeLunch+timeRest)));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",serial,Math.ceil((durationSerial+timeLunch+timeRest)-durationBreak));
        }


    }
}
