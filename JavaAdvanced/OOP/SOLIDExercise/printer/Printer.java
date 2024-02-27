package SoftUni.JavaAdvanced.OOP.SOLIDExercise.printer;

import SoftUni.JavaAdvanced.OOP.SOLIDExercise.calculators.CalorieCalculator;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.calculators.interfaces.Calculator;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.interfaces.Product;

import java.util.List;

public class Printer {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    private Calculator calculator;

    public Printer(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf(SUM + "\n", calculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf(AVERAGE + "\n", calculator.average(products));
    }
}
