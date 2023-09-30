package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numOfJuniors = Integer.parseInt(scan.nextLine());
        int numOfSeniors = Integer.parseInt(scan.nextLine());
        String typeRoute = scan.nextLine();

        double juniorTax = 0;
        double seniorsTax = 0;

        switch (typeRoute){
            case "trail":
                juniorTax=numOfJuniors*5.5;
                        seniorsTax=numOfSeniors*7;
                break;
            case "cross-country":
                juniorTax=numOfJuniors*8;
                        seniorsTax=numOfSeniors*9.5;
                break;
            case "downhill":
                juniorTax=numOfJuniors*12.25;
                        seniorsTax=numOfSeniors*13.75;
                break;
            case "road":
                juniorTax=numOfJuniors*20;
                        seniorsTax=numOfSeniors*21.50;
                break;
        }double tax = juniorTax+seniorsTax;

        if (typeRoute.equals("cross-country")&&(numOfSeniors+numOfJuniors)>=50){
            tax*=0.75;
        }
        double finalTax = tax*0.95;
        System.out.printf("%.2f",finalTax);
    }
}
