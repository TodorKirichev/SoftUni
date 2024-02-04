package Exams.EXAMS.JavaAdvancedRetakeExam12April2023.ClothesMagazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Cloth> getData() {
        return data;
    }

    public void addCloth(Cloth cloth) {
        if (data.size() < capacity) {
            data.add(cloth);
        }
    }
    public boolean removeCloth(String color) {
        return data.removeIf(c -> c.getColor().equals(color));
    }
    public Cloth getSmallestCloth() {
        return data.stream().min(Comparator.comparing(Cloth::getSize)).get();
    }
    public Cloth getCloth(String color) {
        return data.stream().filter(c -> c.getColor().equals(color)).findFirst().get();
    }
    public int getCount() {
        return data.size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder(String.format("%s magazine contains:\n",getType()));
        data.forEach(cloth -> sb.append(cloth).append("\n"));
        return sb.toString().trim();
    }
}
