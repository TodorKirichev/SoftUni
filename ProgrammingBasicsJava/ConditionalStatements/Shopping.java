package ConditionalStatements;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int graphicCards = Integer.parseInt(scan.nextLine());
        int processors = Integer.parseInt(scan.nextLine());
        int ram = Integer.parseInt(scan.nextLine());

        double priceCards = graphicCards*250;
        double priceProcessors = processors*(priceCards*0.35);
        double priceRam = ram*(priceCards*0.1);

        double sum = priceCards+priceProcessors+priceRam;
        if (graphicCards>processors) {
            sum -= sum*0.15;
        }

        if (budget>=sum) {
            System.out.printf("You have %.2f leva left!",budget - sum);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!",sum - budget);
        }
    }
}
