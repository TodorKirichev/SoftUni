package SoftUni.JavaAdvanced.OOP.PolymorphismExercises._2_VehiclesExtended;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Vehicle car = getVehicle(scan);
        Vehicle truck = getVehicle(scan);
        Vehicle bus = getVehicle(scan);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int numOfCommands = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numOfCommands; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];
            double distance;

            try {
                switch (command) {
                    case "Drive":
                        distance = Double.parseDouble(input[2]);
                        System.out.println(vehicles.get(vehicleType).drive(distance));
                        break;
                    case "DriveEmpty":
                        distance = Double.parseDouble(input[2]);
                        System.out.println(vehicles.get(vehicleType).driveEmpty(distance));
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(input[2]);
                        vehicles.get(vehicleType).refuel(liters);
                        break;
                    default:
                        throw new IllegalArgumentException("No such command");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scan) {
        String[] vehicleInfo = scan.nextLine().split("\\s+");
        String vehicleType = vehicleInfo[0];
        double fuelQuantity = Double.parseDouble(vehicleInfo[1]);
        double fuelConsumption = Double.parseDouble(vehicleInfo[2]);
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);

        if (vehicleType.equals("Car")) {
            return new Car(fuelQuantity, fuelConsumption, tankCapacity);
        } else if (vehicleType.equals("Truck")) {
            return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
        } else if (vehicleType.equals("Bus")) {
            return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }
        throw new IllegalArgumentException("Invalid vehicle");
    }
}
