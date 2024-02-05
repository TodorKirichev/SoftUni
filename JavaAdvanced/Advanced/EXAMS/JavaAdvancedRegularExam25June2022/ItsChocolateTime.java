package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRegularExam25June2022;

import java.util.*;

import static java.lang.System.in;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Deque<Double> milkQuantity = new ArrayDeque<>();
        Deque<Double> cacaoPowder = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Double::parseDouble).forEach(milkQuantity::offer);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Double::parseDouble).forEach(cacaoPowder::push);

        Map<String,Integer> chocolates = new TreeMap<>();

        chocolates.put("Milk Chocolate",0);
        chocolates.put("Dark Chocolate",0);
        chocolates.put("Baking Chocolate",0);

        while (!milkQuantity.isEmpty() && !cacaoPowder.isEmpty()) {
            double milk = milkQuantity.poll();
            double cacao = cacaoPowder.pop();

            int result = (int)(cacao / (milk + cacao) * 100);
            
            if (result == 30) {
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
            } else if (result == 50) {
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
            } else if (result == 100) {
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
            } else {
                milk += 10;
                milkQuantity.offer(milk);
            }
        }
        if (isPrepared(chocolates)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolates.entrySet().stream().filter(c -> c.getValue() > 0).forEach(c -> System.out.printf("# %s --> %d\n",c.getKey(),c.getValue()));
    }
    public static boolean isPrepared(Map<String,Integer> chocolates) {
        return chocolates.get("Milk Chocolate") >= 1 && chocolates.get("Dark Chocolate") >= 1 && chocolates.get("Baking Chocolate") >= 1;
    }
}
