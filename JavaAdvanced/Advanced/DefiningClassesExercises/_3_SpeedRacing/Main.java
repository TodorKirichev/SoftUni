package JavaAdvanced.DefiningClassesExercises._3_SpeedRacing;
import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Map<String,Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = scan.nextLine().split("\\s+");
            String model = line[0];
            double fuelAmount = Integer.parseInt(line[1]);
            double fuelPer1Km = Double.parseDouble(line[2]);

            Car car = new Car(model,fuelAmount,fuelPer1Km);
            cars.putIfAbsent(model,car);
        }
        while (true) {
            String line = scan.nextLine();
            if (line.equals("End")) {
                break;
            }
            String[] inputData = line.split("\\s+");
            String model = inputData[1];
            double distance = Integer.parseInt(inputData[2]);

            cars.get(model).drive(distance);
        }
        cars.forEach((key, value) -> System.out.printf("%s %.2f %.0f\n", key,value.getFuelAmount(),value.getDistanceTravelled()));
    }
}
