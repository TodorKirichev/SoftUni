package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int budget = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int fisherman = Integer.parseInt(scan.nextLine());

        double rent = 0;

        switch (season) {
            case"Spring":
                rent=3000;
                break;
            case"Summer":
            case "Autumn":
                rent = 4200;
                break;
            case"Winter":
                rent=2600;
                break;
        }

        if (!season.equals("Autumn") && fisherman%2==0){
            rent=rent*0.95;

        }

        if (fisherman<=6){
            rent=rent*0.9;
        }else if (fisherman>7 && fisherman<=11){
            rent=rent*0.85;
        }else if (fisherman>12){
            rent=rent*0.75;
        }
        double diff = Math.abs(budget-rent);

        if (rent<=budget){
            System.out.printf("Yes! You have %.2f leva left.",diff);
        }else{
            System.out.printf("Not enough money! You need %.2f leva.",diff);
        }


    }
}
