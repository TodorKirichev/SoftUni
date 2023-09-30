package firtsStepsInPrograming;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sqm = Double.parseDouble(scan.nextLine());
        double finalPrice = sqm*7.61;
        double discount = finalPrice*0.18;

        System.out.println("The final price is: " + (finalPrice-discount) + " lv.");
        System.out.println("The discount is: " + discount + " lv.");

    }
}
