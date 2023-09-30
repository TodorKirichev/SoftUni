package ConditionalStatements;

import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int points = Integer.parseInt(scan.nextLine());

        double bonusPoints = 0;
        if (points<=100) {
            bonusPoints =  5;
        } else if (points>100 && points<=1000) {
            bonusPoints = points * 0.2;
        } else if (points>1000) {
            bonusPoints = points*0.1;
        } double extraPoints1 = 0;
          double extraPoints2 = 0;
        if (points%2==0) {
            extraPoints1 = 1;
        }
        if (points%10==5) {
            extraPoints2 = 2;
        }
        double bonus = bonusPoints+extraPoints1+extraPoints2;
        double sum = points + bonus;
        System.out.println(bonus);
        System.out.println(sum);

    }
}
