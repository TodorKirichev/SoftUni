package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam19August2020.VetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }
    public Pet getPet(String name,String owner) {
        return data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst().orElse(null);
    }
    public Pet getOldestPet() {
        return data.stream().max(Comparator.comparingInt(Pet::getAge)).get();
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        data.forEach(p -> sb.append(String.format("%s %s",p.getName(),p.getOwner())).append(System.lineSeparator()));
        return String.format("The clinic has the following patients:\n%s",sb.toString().trim());
    }
}
