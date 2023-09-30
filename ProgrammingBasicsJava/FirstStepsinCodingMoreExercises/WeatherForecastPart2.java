package FirstStepsinCodingMoreExercises;

import java.util.Scanner;

public class WeatherForecastPart2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double degree = Double.parseDouble(scan.nextLine());
        if (degree<5 || degree>35) {
            System.out.println("unknown");
        } else if (degree<12) {
            System.out.println("Cold");
        } else if (degree<15) {
            System.out.println("Cool");
        } else if (degree<=20) {
            System.out.println("Mild");
        } else if (degree<26) {
            System.out.println("Warm");
        }else if (degree<=35) {
            System.out.println("Hot");
        }
    }
}
