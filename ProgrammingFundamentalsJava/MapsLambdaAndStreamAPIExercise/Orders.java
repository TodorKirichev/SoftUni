package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Double> productPrice = new LinkedHashMap<>();
        Map<String,Integer> productQuantity = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("buy")) {

            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);

            if (!productPrice.containsKey(product)) {
                productPrice.put(product,price);
                productQuantity.put(product,quantity);
            } else {
                productQuantity.put(product, productQuantity.get(product) + quantity);
                productPrice.put(product,price);
            }
            input = scan.nextLine();
        }
        productQuantity.forEach((key,value) -> {
            double totalPrice = productQuantity.get(key) * productPrice.get(key);
            System.out.printf("%s -> %.2f\n",key,totalPrice);
        });
    }
}
