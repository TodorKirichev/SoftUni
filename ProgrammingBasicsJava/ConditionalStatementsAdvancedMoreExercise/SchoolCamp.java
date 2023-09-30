package ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String season = scan.nextLine();
        String groupType = scan.nextLine();
        int students = Integer.parseInt(scan.nextLine());
        int nights = Integer.parseInt(scan.nextLine());
        double priceNights = 0;
        String sport = "";

        switch (season){
            case "Winter":
                switch (groupType){
                    case "boys":
                        priceNights = nights * 9.6;
                        sport = "Judo";
                        break;
                    case "girls":
                        priceNights = nights * 9.6;
                        sport = "Gymnastics";
                        break;
                    case "mixed":
                        priceNights = nights * 10;
                        sport = "ski";
                        break;
                }
                break;
            case "Spring":
                switch (groupType){
                    case "boys":
                        priceNights = nights * 7.2;
                        sport = "Tennis";
                        break;
                    case "girls":
                        priceNights = nights * 7.2;
                        sport = "Athletics";
                        break;
                    case "mixed":
                        priceNights = nights * 9.5;
                        sport = "Cycling";
                        break;
                }
                break;
            case "Summer":
                switch (groupType){
                    case "boys":
                        priceNights = nights * 15;
                        sport = "Football";
                        break;
                    case "girls":
                        priceNights = nights * 15;
                        sport = "Volleyball";
                        break;
                    case "mixed":
                        priceNights = nights * 20;
                        sport = "Swimming";
                        break;
                }
                break;
        }
        if (students>=10&&students<20) {
            priceNights*=0.95;
        } else if (students>=20&&students<50) {
            priceNights*=0.85;
        } else if (students>=50){
            priceNights*=0.5;
        }
        System.out.printf("%s %.2f lv.",sport,priceNights*students);
    }
}
