package ConditionalStatements;

import java.util.Scanner;

public class AreaofFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String shape = scan.nextLine();
        double area = 0;
        if (shape.equals("square")) {
            double a = Double.parseDouble(scan.nextLine());
            area = a * a;
        } else if (shape.equals("rectangle")) {
            double a = Double.parseDouble(scan.nextLine());
            double b = Double.parseDouble(scan.nextLine());
            area = a * b;
        } else if (shape.equals("circle")) {
            double r = Double.parseDouble(scan.nextLine());
            area = Math.PI*r*r;
        } else if (shape.equals("triangle")) {
            double a = Double.parseDouble(scan.nextLine());
            double h = Double.parseDouble(scan.nextLine());
            area = a*h/2;

        }
        System.out.printf("%.3f",area);

    }
}
