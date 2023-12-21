package EXAM;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double shipmentKg = Double.parseDouble(scan.nextLine());
        String serviceType = scan.nextLine();
        int distanceKm = Integer.parseInt(scan.nextLine());

        double price = 0;

        switch (serviceType){
            case "standard":
                if (shipmentKg>=90&&shipmentKg<150){
                    price=20*distanceKm;
                } else if (shipmentKg>=40&&shipmentKg<90) {
                    price=15*distanceKm;
                } else if (shipmentKg>=10&&shipmentKg<40) {
                    price=10*distanceKm;
                } else if (shipmentKg>1&&shipmentKg<10) {
                    price=5*distanceKm;
                } else  if (shipmentKg<=1){
                    price=3*distanceKm;
                }
                break;
            case "express":
                if (shipmentKg>=90&&shipmentKg<150){
                    price=(20*distanceKm)+(shipmentKg*0.01*20)*distanceKm;
                } else if (shipmentKg>=40&&shipmentKg<90) {
                    price=(15*distanceKm)+(shipmentKg*0.02*15)*distanceKm;
                } else if (shipmentKg>=10&&shipmentKg<40) {
                    price=(10*distanceKm)+(shipmentKg*0.05*10)*distanceKm;
                } else if (shipmentKg>1&&shipmentKg<10) {
                    price=(5*distanceKm)+(shipmentKg*0.4*5)*distanceKm;
                } else  if (shipmentKg<=1){
                    price=(3*distanceKm)+(shipmentKg*0.8*3)*distanceKm;
                }
                break;
        }
        System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.",shipmentKg,price/100);
    }
}
