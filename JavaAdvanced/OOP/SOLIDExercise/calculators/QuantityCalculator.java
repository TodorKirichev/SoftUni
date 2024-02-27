package SoftUni.JavaAdvanced.OOP.SOLIDExercise.calculators;

import SoftUni.JavaAdvanced.OOP.SOLIDExercise.calculators.interfaces.Calculator;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.interfaces.Product;

import java.util.List;

public class QuantityCalculator implements Calculator {

    public double sum(List<Product> products) {
        return products.stream().mapToDouble(Product::getTotalKg).sum();
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
