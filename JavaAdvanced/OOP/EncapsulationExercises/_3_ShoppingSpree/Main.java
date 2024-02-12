package SoftUni.JavaAdvanced.OOP.EncapsulationExercises._3_ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> peopleMap = new LinkedHashMap<>();

        String[] peoples = scan.nextLine().split(";");
        for (String people : peoples) {
            String name = people.split("=")[0];
            double money = Double.parseDouble(people.split("=")[1]);
            try {
                Person person = new Person(name, money);
                peopleMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        Map<String, Product> productMap = new LinkedHashMap<>();

        String[] products = scan.nextLine().split(";");
        for (String product : products) {
            String name = product.split("=")[0];
            double cost = Double.parseDouble(product.split("=")[1]);
            try {
                Product product1 = new Product(name, cost);
                productMap.put(name, product1);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String command = scan.nextLine();
        while (!"END".equals(command)) {
            String[] input = command.split("\\s+");
            String personName = input[0];
            String productName = input[1];
            Person person = peopleMap.get(personName);
            Product product = productMap.get(productName);
            try {
                person.buyProduct(product);
                System.out.printf("%s %s",person.getName(),product.getName());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = scan.nextLine();
        }
        peopleMap.values().forEach(System.out::println);
    }
}
