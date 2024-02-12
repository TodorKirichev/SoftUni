package SoftUni.JavaAdvanced.OOP.EncapsulationExercises.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] pizzaInfo = scan.nextLine().split("\\s+");
        String name = pizzaInfo[1];
        int numOfToppings = Integer.parseInt(pizzaInfo[2]);

        String[] doughInfo = scan.nextLine().split("\\s+");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double doughWeight = Double.parseDouble(doughInfo[3]);

        try {
            Pizza pizza = new Pizza(name,numOfToppings);
            Dough dough = new Dough(flourType,bakingTechnique,doughWeight);
            pizza.setDough(dough);
            String input = scan.nextLine();
            while (!"END".equals(input)) {
                String[] toppingInfo = input.split("\\s+");
                String toppingType = toppingInfo[1];
                double toppingWeight = Double.parseDouble(toppingInfo[2]);
                try {
                    Topping topping = new Topping(toppingType,toppingWeight);
                    pizza.addTopping(topping);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                input = scan.nextLine();
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
