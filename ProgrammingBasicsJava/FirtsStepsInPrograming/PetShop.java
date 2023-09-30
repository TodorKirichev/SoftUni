package firtsStepsInPrograming;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numPacksFoodDog = Integer.parseInt(scan.nextLine());
        int numPacksFoodCat = Integer.parseInt(scan.nextLine());
        System.out.println((numPacksFoodDog*2.5)+(numPacksFoodCat*4) + " lv.");
    }
}
