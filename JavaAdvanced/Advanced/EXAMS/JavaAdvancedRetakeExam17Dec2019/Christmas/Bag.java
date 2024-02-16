package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam17Dec2019.Christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }
    public int count() {
        return data.size();
    }
    public void add(Present present) {
        if (data.size() < capacity) {
            data.add(present);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }
    public Present heaviestPresent() {
        return data.stream().max(Comparator.comparing(Present::getWeight)).orElse(null);
    }
    public Present getPresent(String name) {
        return data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        data.forEach(p -> sb.append(p).append(System.lineSeparator()));
        return String.format("%s bag contains:\n%s",color,sb.toString().trim());
    }
}
