package SoftUni.JavaAdvanced.Advanced.EXAMS.Exam.sharkHaunt;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addShark(Shark shark) {
        if (sharks.size() < capacity) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }
    public boolean removeShark(String kind) {
        return sharks.removeIf(s -> s.getKind().equals(kind));
    }
    public Shark getLargestShark() {
        return sharks.stream().max(Comparator.comparing(Shark::getLength)).get();
    }
    public Shark getShark(String kind) {
        return sharks.stream().filter(s -> s.getKind().equals(kind)).findFirst().orElse(null);
    }
    public int getCount() {
        return sharks.size();
    }
    public int getAverageLength() {
        return (int) sharks.stream().mapToInt(Shark::getLength).average().orElse(0);
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sharks.forEach(s -> sb.append(s).append(System.lineSeparator()));
        return String.format("Sharks in %s:\n%s",getName(),sb.toString().trim());
    }
}
