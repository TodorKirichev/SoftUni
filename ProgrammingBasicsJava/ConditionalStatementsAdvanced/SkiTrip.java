package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();
        String review = scan.nextLine();
        int nights = days-1;
        double price =0;

        switch (type){
            case "room for one person":
                price = nights*18;

                break;
            case "apartment":
                price=nights*25;
                if (days<10){
                    price=price*0.70;
                }else if (days>=10 && days<=15){
                    price=price*0.65;
                }else {
                    price=price*0.50;
                }

                break;
            case "president apartment":
                price=nights*35;
                if (days<10){
                    price=price*0.90;
                }else if (days>=10 && days<=15){
                    price=price*0.85;
                }else {
                    price=price*0.80;
                }

                break;
        }
        if (review.equals("positive")){
            price=price*1.25;
        } else if (review.equals("negative")) {
            price=price*0.90;
        }
        System.out.printf("%.2f",price);
    }
}
