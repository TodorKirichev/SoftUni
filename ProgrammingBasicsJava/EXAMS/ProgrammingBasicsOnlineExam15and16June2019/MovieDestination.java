package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class MovieDestination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String destination = scan.nextLine();
        String season = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());

        int expense = 0;

        switch (destination){
            case "Dubai":
                switch (season){
                    case "Winter":
                        expense=days*45000;
                        break;
                    case "Summer":
                        expense=days*40000;
                        break;
                }
                break;
            case "Sofia":
                switch (season){
                    case "Winter":
                        expense=days*17000;
                        break;
                    case "Summer":
                        expense=days*12500;
                        break;
                }
                break;
            case "London":
                switch (season){
                    case "Winter":
                        expense=days*24000;
                        break;
                    case "Summer":
                        expense=days*20250;
                        break;
                }
                break;
        }
        if (destination.equals("Dubai")){
            expense*=0.7;
        }
        if (destination.equals("Sofia")){
            expense*=1.25;
        }
        if (budget>=expense){
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!",budget-expense);
        }else {
            System.out.printf("The director needs %.2f leva more!",expense-budget);
        }
    }
}
