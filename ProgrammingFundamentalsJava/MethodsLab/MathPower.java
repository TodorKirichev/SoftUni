package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double number = Double.parseDouble(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());

        System.out.println(new DecimalFormat("0.####").format(mathPower(number,power)));
    }
    public static double mathPower(double number, int power) {
        return Math.pow(number,power);
    }
}
