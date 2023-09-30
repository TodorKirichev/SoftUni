package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        int r = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        double price = 0;

        switch (type) {
            case "Premiere":
                price = 12;
                break;
            case "Normal":
                price = 7.5;
                break;
            case "Discount":
                price = 5;
                break;
        } double total = c*r*price;
        System.out.printf("%.2f",total);
    }
}
