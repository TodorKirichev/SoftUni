package ProgrammingBasicsOnlineExam6and7July2019;

import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int numNights = Integer.parseInt(scan.nextLine());
        double nightPrice = Double.parseDouble(scan.nextLine());
        double percentExpense = Double.parseDouble(scan.nextLine());

        double sumNights = numNights*nightPrice;
        if (numNights>7){
            sumNights*=0.95;
        }
        budget=budget-budget*percentExpense/100;
        double diff = Math.abs(budget-sumNights);
        if (budget>=sumNights){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.",diff);
        }else{
            System.out.printf("%.2f leva needed.",diff);
        }
    }
}
