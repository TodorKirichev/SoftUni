package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam15December2021.WaterAdventure;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
    public int getFishInPool() {
        return fishInPool.size();
    }
    public void add(Fish fish) {
        if (fishInPool.size() < capacity) {
            if (fishInPool.stream().noneMatch(f -> f.getName().equals(fish.getName()))) {
                fishInPool.add(fish);
            }
        }
    }
    public boolean remove (String name) {
        return fishInPool.removeIf(f -> f.getName().equals(name));
    }
    public Fish findFish(String name) {
        return fishInPool.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        fishInPool.forEach(f -> sb.append(f).append("\n"));
        return String.format("Aquarium: %s ^ Size: %d\n%s",getName(),getSize(),sb.toString().trim());
    }
}
