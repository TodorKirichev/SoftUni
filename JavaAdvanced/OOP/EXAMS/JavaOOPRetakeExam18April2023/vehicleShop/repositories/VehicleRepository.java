package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2023.vehicleShop.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class VehicleRepository implements Repository<Vehicle> {
    private Collection<Vehicle> vehicles;

    public VehicleRepository() {
        vehicles = new ArrayList<>();
    }

    @Override
    public Collection<Vehicle> getWorkers() {
        return Collections.unmodifiableCollection(vehicles);
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }

    @Override
    public Vehicle findByName(String name) {
        return vehicles.stream().filter(v -> v.getName().equals(name)).findFirst().get();
    }
}
