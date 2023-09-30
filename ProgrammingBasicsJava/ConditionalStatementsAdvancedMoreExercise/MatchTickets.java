package ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String typeTicket = scan.nextLine();
        int numOfPpls = Integer.parseInt(scan.nextLine());
        double vip = 499.99;
        double normal = 249.99;

        double ticketsPrice = 0;
        double budgetForTransport = 0;

        if (numOfPpls>0&&numOfPpls<=4){
            budgetForTransport=budget*0.75;
        } else if (numOfPpls>4&&numOfPpls<=9) {
            budgetForTransport=budget*0.6;
        } else if (numOfPpls>9&&numOfPpls<=24) {
            budgetForTransport=budget*0.5;
        } else if (numOfPpls>24&&numOfPpls<=49) {
            budgetForTransport=budget*0.4;
        }else if (numOfPpls>49){
            budgetForTransport=budget*0.25;
        }
        double budgetLeft = budget-budgetForTransport;

        switch (typeTicket){
            case "VIP":
                ticketsPrice=vip*numOfPpls;
                break;
            case "Normal":
                ticketsPrice=normal*numOfPpls;
                break;
        }
        if (budgetLeft>=ticketsPrice){
            System.out.printf("Yes! You have %.2f leva left.",budgetLeft-ticketsPrice);
        }else{
            System.out.printf("Not enough money! You need %.2f leva.",ticketsPrice-budgetLeft);
        }

    }
}
