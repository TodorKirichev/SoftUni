package SoftUni.JavaAdvanced.OOP.EncapsulationExercises._2_AnimalFarm;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());

        try {
            Chicken chicken = new Chicken(name,age);
            System.out.println(chicken);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
