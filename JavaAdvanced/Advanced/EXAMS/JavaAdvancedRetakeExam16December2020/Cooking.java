package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> liquids = new ArrayDeque<>();
        Deque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);

        Map<String, Integer> items = new TreeMap<>();
        putItems(items);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            switch (sum) {
                case 25:
                    items.put("Bread",items.get("Bread") + 1);
                    break;
                case 50:
                    items.put("Cake",items.get("Cake") + 1);
                    break;
                case 75:
                    items.put("Pastry",items.get("Pastry") + 1);
                    break;
                case 100:
                    items.put("Fruit Pie",items.get("Fruit Pie") + 1);
                    break;
                default:
                    ingredients.push(ingredient + 3);
                    break;

            }
        }
        if (isAtLeastOneFromAll(items)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s\n",liquids.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s\n",ingredients.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        items.forEach((k,v) -> System.out.printf("%s: %s\n",k,v));
    }

    private static boolean isAtLeastOneFromAll(Map<String, Integer> items) {
        boolean isAtLeastOneFromAll = true;
        for (Integer value : items.values()) {
            if (value <= 0) {
                isAtLeastOneFromAll = false;
                break;
            }
        }
        return isAtLeastOneFromAll;
    }

    private static void putItems(Map<String, Integer> items) {
        items.put("Bread", 0);
        items.put("Cake", 0);
        items.put("Pastry", 0);
        items.put("Fruit Pie", 0);
    }
}
