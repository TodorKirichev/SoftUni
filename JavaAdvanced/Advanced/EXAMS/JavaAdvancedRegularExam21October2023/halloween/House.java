package Advanced.EXAMS.JavaAdvancedRegularExam21October2023.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Kid> data;
    private int capacity;

    public House(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }
    public void addKid(Kid kid) {
        if (data.size() < capacity) {
            data.add(kid);
        }
    }
    public boolean removeKid(String name) {
        boolean isExist = false;
        for (Kid kid : data) {
            if (kid.getName().equals(name)) {
                data.remove(kid);
                isExist = true;
                break;
            }
        }
        return isExist;
    }
    public Kid getKid(String street) {
        return data.stream().filter(kid1 -> kid1.getStreet().equals(street)).findFirst().orElse(null);
    }
    public int getAllKids() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder("Children who visited a house for candy:");
        data.forEach(kid -> sb.append(String.format("\n%s from %s street",kid.getName(),kid.getStreet())));
        return sb.toString();
    }
}
