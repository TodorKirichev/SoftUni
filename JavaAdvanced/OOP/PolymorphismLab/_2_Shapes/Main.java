package SoftUni.JavaAdvanced.OOP.PolymorphismLab._2_Shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Shape rectangle = new Rectangle(4.00,5.00);
        Shape circle = new Circle(6.00);

        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());
        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());
    }
}
