package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numChrysanthemums = Integer.parseInt(scan.nextLine());
        int numRoses = Integer.parseInt(scan.nextLine());
        int numTulips = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        String holiday = scan.nextLine();

        double chrysanthemumPrice=0,rosePrice=0,tulipPrice=0;

        switch (season){
            case "Spring":
            case "Summer":
                chrysanthemumPrice=2;
                rosePrice=4.1;
                tulipPrice=2.5;
                        break;
            case "Autumn":
            case "Winter":
                chrysanthemumPrice=3.75;
                rosePrice=4.5;
                tulipPrice=4.15;
                break;
        }
        double sum = numChrysanthemums*chrysanthemumPrice+numRoses*rosePrice+numTulips*tulipPrice;
        if (holiday.equals("Y")) {
            sum *= 1.15;
        }

            if (numTulips>7&&season.equals("Spring")){
                sum*=0.95;
            }
            if (numRoses>=10&&season.equals("Winter")){
                sum*=0.9;
            }
            if (numChrysanthemums+numRoses+numTulips>20){
                sum*=0.8;
            }

        System.out.printf("%.2f",sum+2);
    }
}
