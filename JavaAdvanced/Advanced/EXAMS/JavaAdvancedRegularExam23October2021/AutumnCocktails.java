package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam23October2021;

import java.util.*;

import static java.lang.System.in;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Integer> ingredients = new ArrayDeque<>();
        Deque<Integer> freshness = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(freshness::push);

        Map<String,Integer> cocktails = new TreeMap<>();
        fill(cocktails);

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            int ingredient = ingredients.poll();
            if (ingredient == 0) {
                continue;
            }
            int fresh = freshness.pop();
            int result = ingredient * fresh;

            switch (result) {
                case 150:
                    cocktails.put("Pear Sour",cocktails.get("Pear Sour") + 1);
                    break;
                case 250:
                    cocktails.put("The Harvest",cocktails.get("The Harvest") + 1);
                    break;
                case 300:
                    cocktails.put("Apple Hinny",cocktails.get("Apple Hinny") + 1);
                    break;
                case 400:
                    cocktails.put("High Fashion",cocktails.get("High Fashion") + 1);
                    break;
                default:
                    ingredients.addLast(ingredient + 5);
                    break;
            }
        }
        if (areMade(cocktails)) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            print(ingredients);
        }
        cocktails.entrySet().stream().filter(entry -> entry.getValue() >= 1)
                .forEach(entry -> System.out.printf(" # %s --> %d\n",entry.getKey(),entry.getValue()));
    }

    private static void fill(Map<String, Integer> cocktails) {
        cocktails.put("Pear Sour",0);
        cocktails.put("The Harvest",0);
        cocktails.put("Apple Hinny",0);
        cocktails.put("High Fashion",0);
    }

    private static void print(Deque<Integer> ingredients) {
        int sum = 0;
        for (Integer ingredient : ingredients) {
            sum += ingredient;
        }
        System.out.printf("Ingredients left: %d\n",sum);
    }

    public static boolean areMade(Map<String,Integer> cocktails) {
        boolean areMade = true;
        for (Integer cocktail : cocktails.values()) {
            if (cocktail < 1) {
                areMade = false;
                break;
            }
        }
        return areMade;
    }
}
