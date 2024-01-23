package JavaAdvanced.DefiningClassesLab.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        int n = Integer.parseInt(scan.nextLine());

        List<Object> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] carInfo = scan.nextLine().split("\\s+");
            String brand;
            String model;
            int horsepower;
            Car car;
            if (carInfo.length == 1) {
                brand = carInfo[0];
                car = new Car(brand);
            } else {
                brand = carInfo[0];
                model = carInfo[1];
                horsepower = Integer.parseInt(carInfo[2]);
                car = new Car(brand,model,horsepower);
            }
            cars.add(car);
        }
        cars.forEach(vehicle -> System.out.println(vehicle.toString()));
    }
}
