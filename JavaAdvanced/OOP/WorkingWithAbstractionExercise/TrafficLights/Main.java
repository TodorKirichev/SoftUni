package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] colors = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());
        List<TrafficLight> trafficLightList = new ArrayList<>();

        for (String color : colors) {
            TrafficLight trafficLight = new TrafficLight(Color.valueOf(color));
            trafficLightList.add(trafficLight);
        }

        for (int i = 0; i < n; i++) {
            trafficLightList.forEach(TrafficLight::changeColor);
            trafficLightList.forEach(t -> System.out.print(t.getColor() + " "));
            System.out.println();
        }
    }
}
