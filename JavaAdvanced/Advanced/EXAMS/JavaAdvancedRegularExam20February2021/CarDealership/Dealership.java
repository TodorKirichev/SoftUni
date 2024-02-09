package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam20February2021.CarDealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
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

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }
    public boolean buy(String manufacturer,String model) {
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }
    public Car getLatestCar() {
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }
    public Car getCar(String manufacturer,String model) {
        return data.stream().filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)).findFirst().orElse(null);
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        data.forEach(c -> sb.append(c).append(System.lineSeparator()));
        return String.format("The cars are in a car dealership %s:\n%s",getName(),sb.toString().trim());
    }
}
