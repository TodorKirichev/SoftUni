package DataTypesandVariablesLab;

import java.util.Scanner;

public class PoundstoDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double pounds = Double.parseDouble(scan.nextLine());
        double usd = pounds*1.36;
        System.out.printf("%.3f",usd);
    }
}
