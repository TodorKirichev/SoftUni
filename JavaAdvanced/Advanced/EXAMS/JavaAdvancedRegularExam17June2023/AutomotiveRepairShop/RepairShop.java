package Advanced.EXAMS.JavaAdvancedRegularExam17June2023.AutomotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepairShop {
    private List<Vehicle> vehicles;
    private int capacity;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
        }
    }
    public boolean removeVehicle(String vin) {
        boolean isExist = vehicles.stream().anyMatch(v -> v.getVIN().equals(vin));
        vehicles = vehicles.stream().filter(v -> !v.getVIN().equals(vin)).collect(Collectors.toList());
        return isExist;
    }
    public int getCount() {
        return vehicles.size();
    }
    public Vehicle getLowestMileage() {
        return vehicles.stream().min(Comparator.comparing(Vehicle::getMileage)).get();
    }
    public String report() {
        StringBuilder sb = new StringBuilder("Vehicles in the preparatory:\n");
        vehicles.forEach(v -> sb.append(v).append(System.lineSeparator()));
        return sb.toString();

    }
}
