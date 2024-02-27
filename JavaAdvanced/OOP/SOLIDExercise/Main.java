package SoftUni.JavaAdvanced.OOP.SOLIDExercise;

import SoftUni.JavaAdvanced.OOP.SOLIDExercise.calculators.CalorieCalculator;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.calculators.QuantityCalculator;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.printer.Printer;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.drink.Coke;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.food.Chips;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.interfaces.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product product = new Chips(100);
        Product product1 = new Coke(100);

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);

        CalorieCalculator calorieCalculator = new CalorieCalculator();
        QuantityCalculator quantityCalculator = new QuantityCalculator();
        Printer printer = new Printer(calorieCalculator);
        printer.printSum(products);
        printer.printAverage(products);
        Printer printer1 = new Printer(quantityCalculator);
        printer1.printSum(products);
        printer1.printAverage(products);

    }
}
