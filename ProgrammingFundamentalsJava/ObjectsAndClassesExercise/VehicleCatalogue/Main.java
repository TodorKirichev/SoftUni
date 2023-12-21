package ObjectsAndClassesExercise.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Catalogue> vehicles = new ArrayList<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("End")) {
                break;
            }
            String type = input.split(" ")[0];
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsepower = Integer.parseInt(input.split(" ")[3]);

            Catalogue vehicle = new Catalogue(type,model,color,horsepower);
            vehicles.add(vehicle);
        }
        while (true) {
            String command = scan.nextLine();

            if (command.equals("Close the Catalogue")) {
                break;
            }
            for (Catalogue vehicle : vehicles) {
                if (command.equals(vehicle.getModel())) {
                    System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                            vehicle.getType().substring(0,1).toUpperCase() + vehicle.getType().substring(1),
                            vehicle.getModel(),
                            vehicle.getColor(),
                            vehicle.getHorsepower());
                    System.out.println();
                }
            }
        }
        int countCars = 0;
        int countTrucks = 0;
        int sumCarsHP = 0;
        int sumTrucksHP = 0;

        for (Catalogue vehicle : vehicles) {
            if (vehicle.getType().equals("car")) {
                countCars++;
                sumCarsHP += vehicle.getHorsepower();
            } else if (vehicle.getType().equals("truck")) {
                countTrucks++;
                sumTrucksHP += vehicle.getHorsepower();
            }
        }
        double averageCarsHP = (double) sumCarsHP / countCars;
        double averageTrucksHP = (double) sumTrucksHP / countTrucks;
        if (countCars == 0) {
            averageCarsHP = 0.0;
        }
        if (countTrucks == 0) {
            averageTrucksHP = 0.0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n",averageCarsHP);
        System.out.printf("Trucks have average horsepower of: %.2f.%n",averageTrucksHP);
    }
}
