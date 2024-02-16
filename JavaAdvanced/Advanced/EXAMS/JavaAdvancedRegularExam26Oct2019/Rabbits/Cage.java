package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam26Oct2019.Rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void add(Rabbit rabbit) {
        if (data.size() < capacity) {
            data.add(rabbit);
        }
    }
    public boolean removeRabbit(String name) {
        return data.removeIf(r -> r.getName().equals(name));
    }
    public void removeSpecies(String species) {
        data = data.stream().filter(r -> !r.getSpecies().equals(species)).collect(Collectors.toList());
    }
    public Rabbit sellRabbit(String name) {
        data.stream().filter(r -> r.getName().equals(name)).findFirst().get().setAvailable(false);
        return data.stream().filter(r -> r.getName().equals(name)).findFirst().get();
    }
    public List<Rabbit> sellRabbitBySpecies(String species) {
        data.stream().filter(r -> r.getSpecies().equals(species)).forEach(r -> r.setAvailable(false));
        return data.stream().filter(r -> r.getSpecies().equals(species)).collect(Collectors.toList());
    }
    public int count() {
        return data.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        data.stream().filter(Rabbit::isAvailable).forEach(r -> sb.append(r).append(System.lineSeparator()));
        return String.format("Rabbits available at %s:\n%s",name,sb.toString().trim());
    }
}
