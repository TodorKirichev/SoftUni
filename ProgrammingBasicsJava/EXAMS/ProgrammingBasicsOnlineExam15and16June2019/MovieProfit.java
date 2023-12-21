package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class MovieProfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String movieName = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());
        int numTickets = Integer.parseInt(scan.nextLine());
        double priceTickets = Double.parseDouble(scan.nextLine());
        int percentForCinema = Integer.parseInt(scan.nextLine());

        double sum = (days*numTickets*priceTickets);
        double profit = sum*(100-percentForCinema)/100;

        System.out.printf("The profit from the movie %s is %.2f lv.",movieName,profit);
    }
}
