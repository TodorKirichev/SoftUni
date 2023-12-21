package ProgrammingFundamentalsFinalExamRetake03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String,Integer> carMileage = new LinkedHashMap<>();
        Map<String,Integer> carFuel = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scan.nextLine().split("\\|");
            String car = carInfo[0];
            int mileage = Integer.parseInt(carInfo[1]);
            int fuel = Integer.parseInt(carInfo[2]);
            carMileage.put(car,mileage);
            carFuel.put(car,fuel);
        }
        while (true) {
            String input = scan.nextLine();
            if (input.equals("Stop")) {
                break;
            }
            String[] commandParts = input.split(" : ");
            String command = commandParts[0];
            String car = commandParts[1];
            switch (command) {
                case "Drive":
                    int distanceToDrive = Integer.parseInt(commandParts[2]);
                    int neededFuel = Integer.parseInt(commandParts[3]);
                    if (carFuel.get(car) < neededFuel) {
                        System.out.printf("Not enough fuel to make that ride\n");
                    } else {
                        carMileage.put(car,carMileage.get(car) + distanceToDrive);
                        carFuel.put(car,carFuel.get(car) - neededFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n",car,distanceToDrive,neededFuel);
                        if (carMileage.get(car) >= 100000) {
                            System.out.printf("Time to sell the %s!\n",car);
                            carMileage.remove(car);
                            carFuel.remove(car);
                        }
                    }
                    break;
                case "Refuel":
                    int fuel = Integer.parseInt(commandParts[2]);
                    int refilled = 0;
                    if (carFuel.get(car) + fuel > 75) {
                        refilled = 75 - carFuel.get(car);
                        carFuel.put(car,75);
                    } else {
                        carFuel.put(car,carFuel.get(car) + fuel);
                        refilled = fuel;
                    }
                    System.out.printf("%s refueled with %d liters\n",car,refilled);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commandParts[2]);
                    carMileage.put(car,carMileage.get(car) - kilometers);
                    if (carMileage.get(car) < 10000) {
                        carMileage.put(car,10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers\n",car,kilometers);
                    }
                    break;
            }
        }
        for (Map.Entry <String,Integer> entry : carMileage.entrySet()) {
            String car = entry.getKey();
            int mileage = entry.getValue();
            int fuel = carFuel.get(car);
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",car,mileage,fuel);
        }
    }
}
