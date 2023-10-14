package DataTypesandVariablesExercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String biggest = "";
        double volume = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            String model = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());

            double V = Math.PI*Math.pow(radius,2)*height;

            if (V > volume){
                volume = V;
                biggest = model;
            }
        }
        System.out.println(biggest);
    }
}
