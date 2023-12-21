package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fruit = scan.nextLine();
        String set = scan.nextLine();
        int numSets = Integer.parseInt(scan.nextLine());
        double price = 0;

        switch (fruit){
            case "Watermelon":
                switch (set){
                    case "small":
                        price=56*2;
                        break;
                    case "big":
                        price=28.7*5;
                        break;
                }
                break;
            case "Mango":
                switch (set){
                    case "small":
                        price=36.66*2;
                        break;
                    case "big":
                        price=19.6*5;
                        break;
                }
                break;
            case "Pineapple":
                switch (set){
                    case "small":
                        price=42.1*2;
                        break;
                    case "big":
                        price=24.8*5;
                        break;
                }
                break;
            case "Raspberry":
                switch (set){
                    case "small":
                        price=20*2;
                        break;
                    case "big":
                        price=15.2*5;
                        break;
                }
                break;
        }
        price=price*numSets;
        if (price>=400&&price<=1000){
            price*=0.85;
        }else if (price>1000){
            price*=0.5;
        }
        System.out.printf("%.2f lv.",price);
    }
}
