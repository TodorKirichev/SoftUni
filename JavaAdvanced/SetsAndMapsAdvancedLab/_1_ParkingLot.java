package JavaAdvanced.SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _1_ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();
        
        while (true) {
            String input = scan.nextLine();
            if (input.equals("END")) {
                break;
            }
            String[] inputData = input.split(",\\s+");
            String direction = inputData[0];
            String carNumber = inputData[1];

            if (direction.equals("IN")) {
                parkingLot.add(carNumber);
            } else if (direction.equals("OUT")) {
                parkingLot.remove(carNumber);
            }
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }
    }
}
