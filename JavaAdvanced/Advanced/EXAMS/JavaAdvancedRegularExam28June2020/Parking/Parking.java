package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam28June2020.Parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }
    public boolean remove(String manufacturer,String model) {
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }
    public Car getLatestCar() {
        return data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }
    public Car getCar(String manufacturer,String model) {
        return data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findFirst().orElse(null);
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        data.forEach(c -> sb.append(c).append(System.lineSeparator()));
        return String.format("The cars are parked in %s:\n%s",type,sb.toString().trim());
    }
}
