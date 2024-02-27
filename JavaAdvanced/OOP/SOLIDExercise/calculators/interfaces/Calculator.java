package SoftUni.JavaAdvanced.OOP.SOLIDExercise.calculators.interfaces;

import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.interfaces.Product;

import java.util.List;

public interface Calculator {

    double sum(List<Product> products);

    double average(List<Product> products);
}
