package JavaAdvanced.FunctionalProgrammingLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

import static java.lang.System.in;

public class _5_FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        Map<String, Integer> peoples = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split(",\\s+");
            peoples.put(data[0], Integer.valueOf(data[1]));
        }
        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Integer> getOlder = p -> p >= age;
        Predicate<Integer> getYounger = p -> p <= age;

        if (condition.equals("younger")) {
            print(peoples, getYounger, format);
        } else if (condition.equals("older")) {
            print(peoples, getOlder, format);
        }
    }

    private static void print(Map<String, Integer> peoples, Predicate<Integer> youngerOrOlder, String format) {
        switch (format) {
            case "name":
                for (Map.Entry<String, Integer> entry : peoples.entrySet()) {
                    if (youngerOrOlder.test(entry.getValue())) {
                        System.out.println(entry.getKey());
                    }
                }
                break;
            case "age":
                for (Map.Entry<String, Integer> entry : peoples.entrySet()) {
                    if (youngerOrOlder.test(entry.getValue())) {
                        System.out.println(entry.getValue());
                    }
                }
                break;
            case "name age":
                for (Map.Entry<String, Integer> entry : peoples.entrySet()) {
                    if (youngerOrOlder.test(entry.getValue())) {
                        System.out.printf("%s - %d\n",entry.getKey(),entry.getValue());
                    }
                }
                break;
        }
    }
}
