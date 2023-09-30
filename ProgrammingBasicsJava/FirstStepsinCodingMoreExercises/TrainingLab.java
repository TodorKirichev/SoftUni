package FirstStepsinCodingMoreExercises;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double l = Double.parseDouble(scan.nextLine());
        double w = Double.parseDouble(scan.nextLine());

        double sidesPerRow = Math.floor((w*100-100)/70);
        double rows = Math.floor(l*100/120);

        System.out.println((int)Math.floor(sidesPerRow*rows)-3);
    }
}
