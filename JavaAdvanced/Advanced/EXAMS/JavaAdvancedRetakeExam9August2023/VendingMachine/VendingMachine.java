package Exams.EXAMS.JavaAdvancedRetakeExam9August2023.VendingMachine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return drinks.size();
    }

    public void addDrink(Drink drink) {
        if (drinks.size() < buttonCapacity) {
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        boolean isInVending;
        isInVending = drinks.stream().anyMatch(d -> d.getName().equals(name));
        drinks = drinks.stream().filter(d -> !d.getName().equals(name)).collect(Collectors.toList());
        return isInVending;
    }

    public Drink getLongest() {
        return drinks.stream().max(Comparator.comparing(Drink::getVolume)).get();
    }

    public Drink getCheapest() {
        return drinks.stream().min(Comparator.comparing(Drink::getPrice)).get();
    }

    public String buyDrink(String name) {
        return drinks.stream().filter(d -> d.getName().equals(name)).findFirst().get().toString();
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Drinks available:\n");
        drinks.forEach(drink -> sb.append(drink).append(System.lineSeparator()));
        return sb.toString();
    }
}
