package JavaAdvanced.SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _6_ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Map<String,Double>> shops = new TreeMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Revision")) {
                break;
            }
            String[] inputData = input.split(",\\s+");
            String shop = inputData[0];
            String product = inputData[1];
            double price = Double.parseDouble(inputData[2]);

            if (shops.containsKey(shop)) {
                Map<String,Double> productsPrice = shops.get(shop);
                productsPrice.putIfAbsent(product,price);
            } else {
                shops.put(shop,new LinkedHashMap<>());
                shops.get(shop).put(product,price);
            }
        }
        shops.forEach((key,value) -> {
            System.out.printf("%s->\n",key);
            value.forEach((product,price) -> {
                System.out.printf("Product: %s, Price: %.1f\n",product,price);
            });
        });
    }
}
