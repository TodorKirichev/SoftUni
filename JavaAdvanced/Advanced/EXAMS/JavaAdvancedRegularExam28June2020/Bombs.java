package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> effects = new ArrayDeque<>();
        Deque<Integer> casings = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(effects::offer);
        Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).forEach(casings::push);

        Map<String,Integer> bombs = new TreeMap<>();
        fill(bombs);

        while (!effects.isEmpty() && !casings.isEmpty()) {
            int effect = effects.poll();
            int casing = casings.pop();
            int sum = effect + casing;

            switch (sum) {
                case 40:
                    bombs.put("Datura Bombs",bombs.get("Datura Bombs") + 1);
                    break;
                case 60:
                    bombs.put("Cherry Bombs",bombs.get("Cherry Bombs") + 1);
                    break;
                case 120:
                    bombs.put("Smoke Decoy Bombs",bombs.get("Smoke Decoy Bombs") + 1);
                    break;
                default:
                    effects.addFirst(effect);
                    casings.push(casing - 5);
                    break;
            }
            if (isEnough(bombs)) {
                break;
            }
        }
        if (isEnough(bombs)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (effects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s\n",
                    effects.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (casings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s\n",
                    casings.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        bombs.forEach((k,v) -> System.out.printf("%s: %s\n",k,v));
    }

    private static boolean isEnough(Map<String, Integer> bombs) {
        for (Integer numOfBombs : bombs.values()) {
            if (numOfBombs < 3) {
                return false;
            }
        }
        return true;
    }

    private static void fill(Map<String, Integer> bombs) {
        bombs.put("Datura Bombs",0);
        bombs.put("Cherry Bombs",0);
        bombs.put("Smoke Decoy Bombs",0);
    }
}
