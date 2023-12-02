package MethodsLab;

import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = Double.parseDouble(scan.nextLine());
        double b = Double.parseDouble(scan.nextLine());

        System.out.printf("%.0f",area(a,b));
    }
    public static double area(double a,double b) {
        return a * b;
    }
}
