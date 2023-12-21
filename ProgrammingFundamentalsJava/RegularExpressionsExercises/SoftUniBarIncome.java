package RegularExpressionsExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String input = scan.nextLine();
        double totalPrice = 0;
        Pattern pattern = Pattern.compile("%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>[0-9]+\\.?[0-9]*)\\$");

        while (!input.equals("end of shift")) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                totalPrice += count * price;
                System.out.printf("%s: %s - %.2f\n",customer,product,count * price);
            }
            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f\n",totalPrice);
    }
}
