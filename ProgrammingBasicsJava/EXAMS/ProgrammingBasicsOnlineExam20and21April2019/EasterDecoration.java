package ProgrammingBasicsOnlineExam20and21April2019;

import java.util.Scanner;

public class EasterDecoration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int clients = Integer.parseInt(scan.nextLine());
        double finalPrice = 0;

        for (int i = 0; i < clients; i++) {

            String input = scan.nextLine();
            double price = 0;
            int counter = 0;

            while (!"Finish".equals(input)) {

                String purchase = input;
                counter++;

                switch (purchase) {
                    case "basket":
                        price += 1.5;
                        break;
                    case "wreath":
                        price += 3.8;
                        break;
                    case "chocolate bunny":
                        price += 7;
                        break;
                }

                input = scan.nextLine();
            }
            if (counter%2==0){
                price*=0.8;
            }
            finalPrice+=price;
            System.out.printf("You purchased %d items for %.2f leva.%n",counter,price);
        }
        System.out.printf("Average bill per client is: %.2f leva.%n",finalPrice/clients);
    }
}
