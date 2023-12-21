package ProgrammingFundamentalsMidExamRetake_1;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        double sum = 0;
        double taxes = 0;

        while (!input.equals("special") && !input.equals("regular")) {

            double price = Double.parseDouble(input);

            if (price < 0) {
                System.out.println("Invalid price!");
                input = scan.nextLine();
                continue;
            }
            taxes += price * 0.2;
            sum += price;

            input = scan.nextLine();
        }
        double total = sum + taxes;

        if (total > 0) {
            if (input.equals("special")) {
                total *= 0.9;
            }
            System.out.printf("Congratulations you've just bought a new computer!%n" +
                    "Price without taxes: %.2f$%n" +
                    "Taxes: %.2f$%n" +
                    "-----------%n" +
                    "Total price: %.2f$%n",sum,taxes,total);
        } else {
            System.out.println("Invalid order!");
        }
    }
}
