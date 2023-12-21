package MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String,String> parking = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String input = scan.nextLine();
            String command = input.split(" ")[0];
            String user = input.split(" ")[1];

            switch (command) {
                case "register":
                    String plate = input.split(" ")[2];
                    if (parking.containsKey(user)) {
                        System.out.printf("ERROR: already registered with plate number %s\n",plate);
                    } else {
                        parking.put(user,plate);
                        System.out.printf("%s registered %s successfully\n",user,plate);
                    }
                    break;
                case "unregister":
                    if (!parking.containsKey(user)) {
                        System.out.printf("ERROR: user %s not found\n",user);
                    } else {
                        System.out.printf("%s unregistered successfully\n",user);
                        parking.remove(user);
                    }
                    break;
            }
        }
        for (Map.Entry<String,String> entry : parking.entrySet()) {
            System.out.printf("%s => %s\n",entry.getKey(),entry.getValue());
        }
    }
}
