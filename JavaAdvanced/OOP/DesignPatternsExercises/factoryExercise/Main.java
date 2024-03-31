package SoftUni.JavaAdvanced.OOP.DesignPatternsExercises.factoryExercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cakeType = scan.nextLine();
        Cake cake = Pastryshop.orderCake(cakeType);
    }
}
