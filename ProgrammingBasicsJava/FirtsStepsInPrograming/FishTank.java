package firtsStepsInPrograming;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int l = Integer.parseInt(scan.nextLine());
        int w = Integer.parseInt(scan.nextLine());
        int h = Integer.parseInt(scan.nextLine());
        double percent = Double.parseDouble(scan.nextLine());

        double volume = (l*w*h);
        double volumeLitters = volume/1000;
        double finalVolume = volumeLitters - (volumeLitters*percent/100);

        System.out.println(finalVolume);



    }
}
