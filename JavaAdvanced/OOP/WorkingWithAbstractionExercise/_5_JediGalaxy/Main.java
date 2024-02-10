package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise._5_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Galaxy galaxy = new Galaxy(scanner);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediData = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            galaxy.setEvil(new Evil(evilData));

            galaxy.moveEvil();

            galaxy.setJedi(new Jedi(jediData));

            sum += galaxy.moveJedi();

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }
}
