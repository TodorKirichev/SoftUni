package JavaAdvanced.DefiningClassesExercises._4_RawData;

import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carInfo = scan.nextLine().split("\\s+");
            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            double tire1Pressure = Double.parseDouble(carInfo[5]);
            int tire1Age = Integer.parseInt(carInfo[6]);
            double tire2Pressure = Double.parseDouble(carInfo[7]);
            int tire2Age = Integer.parseInt(carInfo[8]);
            double tire3Pressure = Double.parseDouble(carInfo[9]);
            int tire3Age = Integer.parseInt(carInfo[10]);
            double tire4Pressure = Double.parseDouble(carInfo[11]);
            int tire4Age = Integer.parseInt(carInfo[12]);

            Car car = new Car(model,engineSpeed,enginePower,cargoWeight,cargoType,
                    tire1Pressure,tire1Age,tire2Pressure,tire2Age,tire3Pressure,tire3Age,tire4Pressure,tire4Age);

            cars.add(car);
        }
        String command = scan.nextLine();

        if (command.equals("fragile")) {
            cars.stream().filter(Car::isFragile).forEach(c -> System.out.println(c.getModel()));
        } else if (command.equals("flamable")) {
            cars.stream().filter(Car::isFlamable).forEach(c -> System.out.println(c.getModel()));
            
        }
    }
}
