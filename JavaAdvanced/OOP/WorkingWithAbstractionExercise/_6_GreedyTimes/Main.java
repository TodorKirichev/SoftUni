package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise._6_GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        Bag bag = new Bag(capacity);

        String[] itemInfo = scanner.nextLine().split("\\s+");

        for (int i = 0; i < itemInfo.length; i += 2) {

            String itemName = itemInfo[i];
            if (itemName.equalsIgnoreCase("Gold")) {
                itemName = "Gold";
            }
            long amount = Long.parseLong(itemInfo[i + 1]);
            try {
                Item item = new Item(ItemType.parse(itemName), itemName, amount);
                bag.add(item);
            } catch (IllegalArgumentException ignored) {
            }
        }

        bag.printContent();
    }

}
