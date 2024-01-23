package JavaAdvanced.DefiningClassesExercises._5_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<Car> cars = new ArrayList<>();
        List<Engine> engines = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] engineInfo = scan.nextLine().split("\\s+");
            String model = engineInfo[0];
            String power = engineInfo[1];

            Engine engine = new Engine(model,power);

            switch (engineInfo.length) {
                case 3 :
                    if (Character.isDigit(engineInfo[2].charAt(0))) {
                        String displacement = engineInfo[2];
                        engine.setDisplacement(displacement);
                    } else {
                        String efficiency = engineInfo[2];
                        engine.setEfficiency(efficiency);
                    }
                    break;
                case 4 :
                    String displacement = engineInfo[2];
                    String efficiency = engineInfo[3];
                    engine.setDisplacement(displacement);
                    engine.setEfficiency(efficiency);
                    break;
            }
            engines.add(engine);
        }
        int m = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carInfo = scan.nextLine().split("\\s+");
            String carModel = carInfo[0];
            String engineModel = carInfo[1];

            Car car = new Car(carModel,engineModel);

            switch (carInfo.length) {
                case 3 :
                    if (Character.isDigit(carInfo[2].charAt(0))) {
                        String weight = carInfo[2];
                        car.setWeight(weight);
                    } else {
                        String color = carInfo[2];
                        car.setColor(color);
                    }
                    break;
                case 4 :
                    String weight = carInfo[2];
                    String color = carInfo[3];
                    car.setWeight(weight);
                    car.setColor(color);
                    break;
            }
            cars.add(car);
        }
        cars.forEach(c -> {
            Engine engineModel = null;
            for (Engine engine : engines) {
                if (engine.getEngineModel().equals(c.getEngineModel())) {
                    engineModel = engine;
                }
            }
            System.out.printf("%s:\n%sWeight: %s\nColor: %s\n",c.getCarModel(),engineModel,c.getWeight(),c.getColor());
        });
    }
}
