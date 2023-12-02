package MethodsLab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int quantity = Integer.parseInt(scan.nextLine());

        printPrice(input,quantity);
    }
    public static void printPrice(String input,int quantity) {
        double price = 0;
        switch (input) {

            case "coffee":
                 price = 1.5;
                break;
            case "water":
                 price = 1;
                break;
            case "coke":
                 price = 1.4;
                break;
            case "snacks":
                 price = 2;
                break;
        }
        System.out.printf("%.2f",price * quantity);
    }
}
