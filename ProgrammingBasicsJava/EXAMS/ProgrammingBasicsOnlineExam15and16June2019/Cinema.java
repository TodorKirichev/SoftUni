package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hallCapacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int priceTicket = 5;
        int finalPrice = 0;

        while (!"Movie time!".equals(input)){

            int peoples = Integer.parseInt(input);

            if (hallCapacity<peoples){
                hallCapacity=hallCapacity-peoples;
                break;
            }
            hallCapacity-=peoples;
            finalPrice+= peoples * priceTicket;

            if (peoples%3==0){
                finalPrice-=5;
            }

            input= scan.nextLine();
        }
        if (hallCapacity>=0){
            System.out.printf("There are %d seats left in the cinema.%n",hallCapacity);
        }else {
            System.out.printf("The cinema is full.%n");
        }
        System.out.printf("Cinema income - %d lv.",finalPrice);
    }
}
