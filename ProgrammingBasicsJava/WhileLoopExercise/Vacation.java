package WhileLoopExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double moneyForTour = Double.parseDouble(scan.nextLine());
        double currentMoney = Double.parseDouble(scan.nextLine());
        int spendCounter = 0;
        int days = 0;

        while (currentMoney < moneyForTour) {
            String act = scan.nextLine();
            double actMoney = Double.parseDouble(scan.nextLine());
            days++;

            switch (act) {
                case "spend":
                    currentMoney -= actMoney;
                    spendCounter++;
                    if ( currentMoney<0) {
                        currentMoney = 0;
                    }
                    break;
                case "save":
                    currentMoney += actMoney;
                   spendCounter=0;
                    break;
            }
            if (spendCounter==5){
                break;
            }
        }
        if (spendCounter == 5) {
            System.out.println("You can't save the money.");
            System.out.println(days);
        }
        else  {
            System.out.printf("You saved the money for %d days.",days);
        }
    }
}
