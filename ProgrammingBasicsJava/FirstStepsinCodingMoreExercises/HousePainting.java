package FirstStepsinCodingMoreExercises;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x = Double.parseDouble(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double sides = ((x*x-1.2*2) + (x*x))+(2*(x*y-1.5*1.5));
        double roof = (2*x*y) +(2*(x*h/2));

        double green = sides/3.4;
        double red = roof/4.3;

        System.out.printf("%.2f%n",green);
        System.out.printf("%.2f",red);
    }
}
