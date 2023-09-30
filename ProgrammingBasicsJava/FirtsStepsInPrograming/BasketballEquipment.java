package firtsStepsInPrograming;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int fee = Integer.parseInt(scan.nextLine());
        double sneekers = fee*0.6;
        double suit = sneekers*0.8;
        double ball = suit/4;
        double acc = ball/5;

        double sum = fee+sneekers+suit+ball+acc;
        System.out.println(sum);
    }
}
