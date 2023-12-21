package FINALEXAM;

import java.util.*;

public class First {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> guestList = new LinkedHashMap<>();
        int unlikedMeals = 0;
        while (true) {
            String input = scan.nextLine();
            if ( input.equals("Stop")) {
                break;
            }
            String[] commandParts = input.split("-");
            String command = commandParts[0];
            String guest = commandParts[1];
            String meal = commandParts[2];
            switch (command) {
                case "Like":
                    if (!guestList.containsKey(guest)) {
                        guestList.put(guest,new ArrayList<>());
                        guestList.get(guest).add(meal);
                    } else {
                        if (!guestList.get(guest).contains(meal)) {
                            guestList.get(guest).add(meal);
                        }
                    }
                    break;
                case "Dislike":
                    if (guestList.containsKey(guest)) {
                        if (guestList.get(guest).contains(meal)) {
                            guestList.get(guest).remove(meal);
                            unlikedMeals++;
                            System.out.printf("%s doesn't like the %s.\n",guest,meal);
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.\n",guest,meal);
                        }
                    } else {
                        System.out.printf("%s is not at the party.\n",guest);
                    }
                    break;
            }
        }
        guestList.forEach((key,value) -> {
            System.out.printf("%s: ",key);
            System.out.print(String.join(", ",value));
            System.out.println();
        });
        System.out.printf("Unliked meals: %d\n",unlikedMeals);
    }
}
