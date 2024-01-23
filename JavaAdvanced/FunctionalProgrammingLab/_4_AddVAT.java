package JavaAdvanced.FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.lang.System.in;

public class _4_AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Function<Double,Double> addVat = n -> n * 1.2;
        Consumer<Double> print = price -> System.out.printf("%.2f\n",price);

        double[] prices = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.println("Prices with VAT:");
        for (double price : prices) {
            double recalculated = addVat.apply(price);
            print.accept(recalculated);
        }
    }
}
