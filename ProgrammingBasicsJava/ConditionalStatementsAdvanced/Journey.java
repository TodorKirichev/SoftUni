package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        double spent = 0;
        String destination = "";
        String type = "";

        if (budget<=100){
            destination="Bulgaria";
            if (season.equals("summer")){
                spent = budget*0.30;
            }else if (season.equals("winter")){
                spent = budget*0.70;
            }

        } else if (budget<=1000){
            destination="Balkans";
            if (season.equals("summer")){
                spent=budget*0.40;
            }else if (season.equals("winter")){
                spent = budget*0.80;
            }
            
        } else if (budget>1000){
            destination="Europe";
                spent=budget*0.90;

        }
        if (season.equals("summer")){
            type="Camp";
        }else if (season.equals("winter")){
            type="Hotel";
        }
        if (destination.equals("Europe")){
            type="Hotel";
        }
        System.out.printf("Somewhere in %s%n",destination);
        System.out.printf("%s - %.2f",type,spent);


    }
}
