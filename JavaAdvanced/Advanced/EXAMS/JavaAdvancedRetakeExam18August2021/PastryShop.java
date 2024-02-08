package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam18August2021;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> liquids = new ArrayDeque<>();
        Deque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);
        Map<String,Integer> foods = new LinkedHashMap<>();
        fill(foods);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            switch (sum) {
                case 25:
                    foods.put("Biscuit",foods.get("Biscuit") + 1);
                    break;
                case 50:
                    foods.put("Cake",foods.get("Cake") + 1);
                    break;
                case 75:
                    foods.put("Pastry",foods.get("Pastry") + 1);
                    break;
                case 100:
                    foods.put("Pie",foods.get("Pie") + 1);
                    break;
                default:
                    ingredients.push(ingredient + 3);
                    break;
            }
        }
        if (atLeastOneFromAll(foods)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        print(liquids, "Liquids left: none", "Liquids left: %s\n");

        print(ingredients, "Ingredients left: none", "Ingredients left: %s\n");

        foods.forEach((k,v) -> System.out.printf("%s: %d\n",k,v));
    }

    private static void print(Deque<Integer> liquids, String x, String format) {
        if (liquids.isEmpty()) {
            System.out.println(x);
        } else {
            System.out.printf(format, liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    private static boolean atLeastOneFromAll(Map<String, Integer> foods) {
        return foods.entrySet().stream().allMatch(f -> f.getValue() > 0);
    }

    private static void fill(Map<String, Integer> foods) {
        foods.put("Biscuit",0);
        foods.put("Cake",0);
        foods.put("Pie",0);
        foods.put("Pastry",0);
    }
}
