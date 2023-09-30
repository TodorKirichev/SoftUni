package ConditionalStatementsAdvancedMoreExercise;

import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double i = Double.parseDouble(scan.nextLine());

        while (i>=0){
            i*=2;
            System.out.printf("Result: %.2f%n",i);
            i=Double.parseDouble(scan.nextLine());
        }
        System.out.println("Negative number!");
    }
}
