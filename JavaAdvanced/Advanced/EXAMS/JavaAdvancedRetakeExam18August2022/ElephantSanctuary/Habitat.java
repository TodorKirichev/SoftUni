package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam18August2022.ElephantSanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private int capacity;
    private List<Elephant> data;
    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(elephant -> elephant.getName().equals(name));
    }
    public Elephant getElephant(String retiredFrom) {
        return data.stream().filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom)).findFirst().orElse(null);
    }
    public Elephant getOldestElephant() {
        return data.stream().max(Comparator.comparing(Elephant::getAge)).orElse(null);
    }
    public int getAllElephants() {
        return data.size();
    }
    public String getReport() {
        StringBuilder sb = new StringBuilder("Saved elephants in the park:\n");
        data.forEach(elephant -> sb.append(String.format("%s came from: %s\n",elephant.getName(),elephant.getRetiredFrom())));
        return sb.toString().trim();
    }
}
