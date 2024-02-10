package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam19February2022.Parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

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
    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }
    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }
    public Parrot sellParrot(String name) {
        data.stream().filter(p -> p.getName().equals(name)).findFirst().get().setAvailable(false);
        return data.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }
    public List<Parrot> sellParrotBySpecies(String species) {
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
            }
        }
        return data.stream().filter(p -> p.getSpecies().equals(species)).collect(Collectors.toList());
    }
    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        data.stream().filter(Parrot::isAvailable).forEach(p -> sb.append(p).append(System.lineSeparator()));
        return String.format("Parrots available at %s:\n%s",getName(),sb.toString().trim());
    }
}
