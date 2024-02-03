package Advanced.EXAMS.JavaAdvancedRetakeExam13December2023.FishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private List<Fish> fishes;
    private int capacity;

    public Pond(int capacity) {
        this.fishes = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addFish(Fish fish) {
        if (this.capacity > this.fishes.size()) {
            this.fishes.add(fish);
        }
    }
    public boolean removeFish(String species) {
        Fish fish = this.fishes.stream().filter(f -> f.getSpecies().equals(species)).findFirst().orElse(null);
        this.fishes.remove(fish);
        return fish != null;
    }
    public Fish getOldestFish() {
        Fish oldest = null;
        int years = Integer.MIN_VALUE;
        for (Fish fish : this.fishes) {
            if (fish.getAge() > years) {
                oldest = fish;
                break;
            }
        }
        return oldest;
    }
    public Fish getFish(String species) {
        Fish fish = null;
        for (Fish f : this.fishes) {
            if (f.getSpecies().equals(species)) {
                fish = f;
                break;
            }
        }
        return fish;
    }
    public int getCount() {
        return this.fishes.size();
    }
    public int getVacancies() {
        return this.capacity - this.fishes.size();
    }
    public String report() {
        StringBuilder output = new StringBuilder("Fishes in the pond:\n");
        fishes.forEach(output::append);
        return output.toString();
    }
}
