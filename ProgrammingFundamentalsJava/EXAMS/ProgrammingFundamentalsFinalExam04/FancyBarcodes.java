package ProgrammingFundamentalsFinalExam04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern pattern = Pattern.compile("@#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+");
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String product = matcher.group("product");
                StringBuilder group = new StringBuilder() ;
                boolean isDefault = true;
                for (int j = 0; j < product.length(); j++) {
                    char symbol = product.charAt(j);
                    if (Character.isDigit(symbol)) {
                        group.append(symbol);
                        isDefault = false;
                    }
                }
                if (isDefault) {
                    group = new StringBuilder("00");
                }
                System.out.printf("Product group: %s\n",group);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
