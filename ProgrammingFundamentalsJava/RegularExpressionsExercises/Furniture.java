package RegularExpressionsExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<String> furnitures = new ArrayList<>();
        double totalPrice = 0;
        Pattern pattern = Pattern.compile(">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>\\d+)");

        String input = scan.nextLine();

        while (!input.equals("Purchase")) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furnitures.add(furniture);
                totalPrice += price * quantity;
            }
            input = scan.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String furniture : furnitures) {
            System.out.println(furniture);
        }
        System.out.printf("Total money spend: %.2f",totalPrice);
    }
}
