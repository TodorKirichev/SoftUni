package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class Orders_9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int orders = Integer.parseInt(scan.nextLine());
        double total = 0;

        for (int i = 1; i <=orders ; i++) {

            double pricePerCapsule = Double.parseDouble(scan.nextLine());
            int days = Integer.parseInt(scan.nextLine());
            int capsulesCount = Integer.parseInt(scan.nextLine());

            double price = pricePerCapsule*days*capsulesCount;

            total+=price;

            System.out.printf("The price for the coffee is: $%.2f%n",price);
        }
        System.out.printf("Total: $%.2f",total);
    }
}
