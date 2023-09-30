package firtsStepsInPrograming;

import java.util.Scanner;

public class GreetingbyName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Hello," + name + "!");
    }
}