package MapsLambdaAdStreamAPIMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,String> contestAndPassword = new LinkedHashMap<>();
        Map<String,Map<String,Integer>> userContestPoints = new TreeMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("end of contests")) {
                break;
            }
            String contest = input.split(":")[0];
            String password = input.split(":")[1];

            contestAndPassword.put(contest,password);
        }
        while (true) {
            String input = scan.nextLine();
            if (input.equals("end of submissions")) {
                break;
            }
            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);

            if (contestAndPassword.containsKey(contest)
                    && password.equals(contestAndPassword.get(contest))) {
                if (userContestPoints.containsKey(username)) {
                    Map<String,Integer> contestAndPoints = userContestPoints.get(username);
                    if (contestAndPoints.containsKey(contest)) {
                        if (points > contestAndPoints.get(contest)) {
                            contestAndPoints.put(contest,points);
                        }
                    } else {
                        contestAndPoints.put(contest,points);
                    }
                } else {
                    userContestPoints.put(username,new LinkedHashMap<>());
                    userContestPoints.get(username).put(contest,points);
                }
            }
        }
        String bestUser = "";
        int bestPoints = 0;
        for (Map.Entry<String,Map<String,Integer>> entry : userContestPoints.entrySet()) {

            int points = 0;

            Map<String,Integer> contestAndPoints = entry.getValue();

            for (Map.Entry<String,Integer> entry1 : contestAndPoints.entrySet()) {
                points += entry1.getValue();
            }
            if (points > bestPoints) {
                bestPoints = points;
                bestUser = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.\n",bestUser,bestPoints);
        System.out.println("Ranking: ");
        for (Map.Entry<String,Map<String,Integer>> entry : userContestPoints.entrySet()) {

            System.out.printf("%s\n",entry.getKey());

            entry.getValue()
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                    .forEach((key,value) -> {
                        System.out.printf("#  %s -> %d\n",key,value);
                    });
        }
        System.out.println();
    }
}
