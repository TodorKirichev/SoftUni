package FirstStepsinCodingMoreExercises;

import java.util.Scanner;

public class CircleAreaandPerimeter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double r = Double.parseDouble(scan.nextLine());

        double s = Math.PI*r*r;
        double p = 2*Math.PI*r;

        System.out.printf("%.2f%n",s);
        System.out.printf("%.2f",p);
    }
}
