package SoftUni.JavaAdvanced.OOP.InheritanceExercises.Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!"Beast!".equals(command)) {

            try {
                String type = command;
                String[] animalInfo = scan.nextLine().split("\\s+");
                String name = animalInfo[0];
                int age = Integer.parseInt(animalInfo[1]);
                String gender = animalInfo[2];
                Animal animal = null;

                switch (type) {
                    case "Cat":
                        animal = new Cat(name,age,gender);
                        break;
                    case "Dog":
                        animal = new Dog(name,age,gender);
                        break;
                    case "Frog":
                        animal = new Frog(name,age,gender);
                        break;
                    case "Kitten":
                        animal = new Kitten(name,age);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name,age);
                        break;
                }
                animals.add(animal);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scan.nextLine();
        }
        animals.forEach(System.out::println);
    }
}
