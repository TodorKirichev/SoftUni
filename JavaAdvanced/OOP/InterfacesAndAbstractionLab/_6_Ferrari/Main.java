package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionLab._6_Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        Car car = new Ferrari(name);
        System.out.println(car);
    }
}
