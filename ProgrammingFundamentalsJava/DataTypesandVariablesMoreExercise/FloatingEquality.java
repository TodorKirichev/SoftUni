package DataTypesandVariablesMoreExercise;

import java.math.BigDecimal;
import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        BigDecimal first = new BigDecimal(scan.nextLine());
        BigDecimal second = new BigDecimal(scan.nextLine());
        BigDecimal eps = BigDecimal.valueOf(0.000001);

        BigDecimal diff = first.subtract(second).abs();


        if (diff.compareTo(eps) < 0) {
            System.out.print("True");
        } else if (diff.compareTo(eps) > 0) {
            System.out.print("False");
        } else {
            System.out.print("False");
        }
    }
}
