package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> forceBook = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains("|")) {
                String forceSide = input.split(" \\| ")[0];
                String forceUser = input.split(" \\| ")[1];
                if (!forceBook.containsKey(forceSide)) {
                    forceBook.put(forceSide,new ArrayList<>());
                }
                boolean isExist = false;

                for (List<String> list : forceBook.values()) {
                    if (list.contains(forceUser)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    forceBook.get(forceSide).add(forceUser);
                }
            } else if (input.contains("->")) {
                String forceUser = input.split(" -> ")[0];
                String forceSide = input.split(" -> ")[1];

                for (List<String> list : forceBook.values()) {
                    list.remove(forceUser);
                }
                if (!forceBook.containsKey(forceSide)) {
                    forceBook.put(forceSide,new ArrayList<>());
                    forceBook.get(forceSide).add(forceUser);
                } else {
                    forceBook.get(forceSide).add(forceUser);
                }
                System.out.printf("%s joins the %s side!\n",forceUser,forceSide);
            }
            input = scan.nextLine();
        }
        forceBook.entrySet().stream().filter(entry -> entry.getValue().size() > 0).forEach(entry -> {
            if (!entry.getKey().isEmpty()) {
                System.out.printf("Side: %s, Members: %d\n",entry.getKey(),entry.getValue().size());
                entry.getValue().forEach(member -> System.out.printf("! %s\n",member));
            }
        });
    }
}
