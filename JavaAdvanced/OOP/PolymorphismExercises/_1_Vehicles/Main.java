package SoftUni.JavaAdvanced.OOP.PolymorphismExercises._1_Vehicles;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Vehicle car = getVehicle(scan);
        Vehicle truck = getVehicle(scan);

        Map<String,Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car",car);
        vehicles.put("Truck",truck);

        int numOfCommands = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numOfCommands; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(input[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(input[2]);
                    vehicles.get(vehicleType).refuel(liters);
                    break;
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scan) {
        String[] vehicleInfo = scan.nextLine().split("\\s+");
        String vehicleType = vehicleInfo[0];
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double fuelConsumption = Double.parseDouble(vehicleInfo[2]);

        if (vehicleType.equals("Car")) {
            return new Car(fuelQuantity,fuelConsumption);
        } else if (vehicleType.equals("Truck")) {
            return new Truck(fuelQuantity,fuelConsumption);
        }
        throw new IllegalArgumentException("Invalid vehicle");
    }
}
