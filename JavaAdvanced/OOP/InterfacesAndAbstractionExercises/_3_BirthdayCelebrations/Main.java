package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._3_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Birthable> birthableList = new ArrayList<>();

        while (!"End".equals(input)) {

            String[] info = input.split("\\s+");
            String type = info[0];

            Birthable birthable = null;
            if (type.equals("Citizen")) {
                String name = info[1];
                int age = Integer.parseInt(info[2]);
                String id = info[3];
                String birthDate = info[4];
                birthable = new Citizen(name,age,id,birthDate);
            } else if (type.equals("Robot")) {
                String model = info[1];
                String id = info[2];
            } else if (type.equals("Pet")) {
                String name = info[1];
                String birthDate = info[2];
                birthable = new Pet(name,birthDate);
            }
            birthableList.add(birthable);
            input = scan.nextLine();
        }
        String year = scan.nextLine();
        birthableList.stream()
                .filter(b -> b != null && b.getBirthDate().endsWith(year))
                .forEach(b -> System.out.printf("%s\n",b.getBirthDate()));
    }
}
