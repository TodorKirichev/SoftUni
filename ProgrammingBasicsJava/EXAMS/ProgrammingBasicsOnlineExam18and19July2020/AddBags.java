package ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double baggageOver20 = Double.parseDouble(scan.nextLine());
        double kgBaggage = Double.parseDouble(scan.nextLine());
        int daysOfTrip = Integer.parseInt(scan.nextLine());
        int numBaggage = Integer.parseInt(scan.nextLine());

        double priceBaggage = 0;

        if (kgBaggage<10){
            priceBaggage=baggageOver20*0.2;
        }else if (kgBaggage>=10&&kgBaggage<=20){
            priceBaggage=baggageOver20*0.5;
        }else{
            priceBaggage=baggageOver20;
        }
        if (daysOfTrip>30){
            priceBaggage*=1.1;
        }else if (daysOfTrip>=7){
            priceBaggage*=1.15;
        }else {
            priceBaggage*=1.4;
        }
        System.out.printf("The total price of bags is: %.2f lv. ",priceBaggage*numBaggage);
    }
}
