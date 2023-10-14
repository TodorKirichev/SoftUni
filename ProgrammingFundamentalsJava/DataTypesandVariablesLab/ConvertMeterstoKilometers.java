package DataTypesandVariablesLab;

import java.util.Scanner;

public class ConvertMeterstoKilometers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int meters = Integer.parseInt(scan.nextLine());
        double km = (double) meters/1000;
        System.out.printf("%.2f",km);
    }
}
