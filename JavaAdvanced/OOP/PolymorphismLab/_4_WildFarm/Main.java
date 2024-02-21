package SoftUni.JavaAdvanced.OOP.PolymorphismLab._4_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scan.nextLine();

        while (!"End".equals(input)) {

            String[] animalInfo = input.split("\\s+");
            String[] foodInfo = scan.nextLine().split("\\s+");

            Animal animal = getAnimal(animalInfo);
            Food food = getFood(foodInfo);

            animal.makeSound();
            animal.eat(food);
            animals.add(animal);

            input = scan.nextLine();
        }
        animals.forEach(System.out::println);
    }

    private static Food getFood(String[] foodInfo) {
        Food food = null;
        String foodName = foodInfo[0];
        Integer foodQuantity = Integer.valueOf(foodInfo[1]);

        if (foodName.equals("Meat")) {
            food = new Meat(foodQuantity);
        } else if (foodName.equals("Vegetable")) {
            food = new Vegetable(foodQuantity);
        }
        return food;
    }

    private static Animal getAnimal(String[] animalInfo) {
        Animal animal = null;
        String animalType = animalInfo[0];
        String animalName = animalInfo[1];
        Double animalWeight = Double.valueOf(animalInfo[2]);
        String animalLivingRegion = animalInfo[3];

        if (animalType.equals("Cat")) {
            String catBreed = animalInfo[4];
            animal = new Cat(animalType,animalName,animalWeight,animalLivingRegion,catBreed);
        } else if (animalType.equals("Tiger")){
            animal = new Tiger(animalType,animalName,animalWeight,animalLivingRegion);
        } else if (animalType.equals("Mouse")) {
            animal = new Mouse(animalType,animalName,animalWeight,animalLivingRegion);
        } else if (animalType.equals("Zebra")) {
            animal = new Zebra(animalType,animalName,animalWeight,animalLivingRegion);
        }
        return animal;
    }
}
