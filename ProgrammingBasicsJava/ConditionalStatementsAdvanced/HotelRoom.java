package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());
        double studio = 0;
        double apartment = 0;

        switch (month){

            case "May":
            case "October":
                studio=50;
                apartment=65;
                if (nights>7 && nights<=14){
                    studio=studio*0.95;
                }else if (nights>14){
                    studio=studio*0.70;
                }

                break;
            case "June":
            case "September":
                studio=75.20;
                apartment=68.70;
                if (nights>14){
                    studio=studio*0.80;
                }

                break;
            case "July":
            case "August":
                studio=76;
                apartment=77;

                break;

        }
        if (nights>14){
            apartment=apartment*0.90;
        }
        double priceApartment = apartment*nights;
        double priceStudio = studio*nights;
        System.out.printf("Apartment: %.2f lv.%n",priceApartment);
        System.out.printf("Studio: %.2f lv.",priceStudio);
    }
}
