package MapsLambdaAndStreamAPIExercise;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class AMinerTask {
    public static void main(String[] args) {

        Scanner scan = new Scanner(in);

        Map<String,Integer> resources = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("stop")) {

            int quantity = Integer.parseInt(scan.nextLine());

            if (resources.containsKey(input)) {
                resources.put(input, resources.get(input) + quantity);
            } else {
                resources.put(input,quantity);
            }
            input = scan.nextLine();
        }
        resources.forEach((key,value) -> System.out.printf("%s -> %d\n",key,value));
    }
}
