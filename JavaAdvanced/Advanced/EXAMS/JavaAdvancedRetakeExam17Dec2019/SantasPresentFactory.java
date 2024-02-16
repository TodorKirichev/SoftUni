package SoftUni.JavaAdvanced.Advanced.EXAMS.JavaAdvancedRetakeExam17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> materials = new ArrayDeque<>();
        Deque<Integer> magicLevel = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(materials::push);
        Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).forEach(magicLevel::offer);

        Map<String,Integer> toys = new TreeMap<>();
        toys.put("Doll",0);
        toys.put("Wooden train",0);
        toys.put("Teddy bear",0);
        toys.put("Bicycle",0);

        while (!materials.isEmpty() && !magicLevel.isEmpty()) {
            int material = materials.pop();
            int value = magicLevel.poll();
            int result = material * value;

            if (result == 150) {
                toys.put("Doll",toys.get("Doll") + 1);
            } else if (result == 250) {
                toys.put("Wooden train",toys.get("Wooden train") + 1);
            } else if (result == 300) {
                toys.put("Teddy bear",toys.get("Teddy bear") + 1);
            } else if (result == 400) {
                toys.put("Bicycle",toys.get("Bicycle") + 1);
            } else if (result < 0){
                materials.push(material + value);
            } else if (result == 0) {
                if (material > 0) {
                    materials.push(material);
                }
                if (value > 0) {
                    magicLevel.addFirst(value);
                }
            } else {
                materials.push(material + 15);
            }
        }
        if (dollAndTrain(toys) || bearAndBicycle(toys)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()) {
            System.out.printf("Materials left: %s\n"
                    ,materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!magicLevel.isEmpty()) {
            System.out.printf("Magic left: %s\n"
                    ,magicLevel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        toys.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .forEach(entry -> System.out.printf("%s: %d\n",entry.getKey(),entry.getValue()));
    }
    public static boolean dollAndTrain(Map<String,Integer> toys) {
        if (toys.get("Doll") <= 0) {
            return false;
        }
        if (toys.get("Wooden train") <= 0) {
            return false;
        }
        return true;
    }
    public static boolean bearAndBicycle(Map<String,Integer> toys) {
        if (toys.get("Teddy bear") <= 0) {
            return false;
        }
        if (toys.get("Bicycle") <= 0) {
            return false;
        }
        return true;
    }
}
