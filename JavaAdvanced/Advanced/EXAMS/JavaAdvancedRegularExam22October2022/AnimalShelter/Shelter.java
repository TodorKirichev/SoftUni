package Exams.EXAMS.JavaAdvancedRegularExam22October2022.AnimalShelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }
    public boolean remove (String name) {
        return data.removeIf(a -> a.getName().equals(name));
    }
    public Animal getAnimal(String name,String caretaker) {
        return data.stream().filter(a -> a.getName().equals(name) && a.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }
    public Animal getOldestAnimal() {
        return data.stream().max(Comparator.comparing(Animal::getAge)).get();
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The shelter has the following animals:\n");
        data.forEach(a -> sb.append(a.getName() + " " + a.getCaretaker()).append("\n"));
        return sb.toString().trim();
    }
}
