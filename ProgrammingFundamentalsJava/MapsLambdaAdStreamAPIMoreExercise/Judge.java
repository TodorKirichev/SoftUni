package MapsLambdaAdStreamAPIMoreExercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Judge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Map<String,Integer>> contestUserPoints = new LinkedHashMap<>();
        Map<String,Integer> individualStanding = new LinkedHashMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("no more time")) {
                break;
            }
            String username = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);

            if (contestUserPoints.containsKey(contest)) {
                if (contestUserPoints.get(contest).containsKey(username)) {
                    if (points > contestUserPoints.get(contest).get(username)) {
                        contestUserPoints.get(contest).put(username,points);
                        individualStanding.put(username,points);
                    }
                } else {
                    contestUserPoints.get(contest).put(username,points);
                    if (individualStanding.containsKey(username)) {
                        individualStanding.put(username,individualStanding.get(username) + points);
                    } else {
                        individualStanding.put(username,points);
                    }
                }
            } else {
                contestUserPoints.put(contest,new LinkedHashMap<>());
                contestUserPoints.get(contest).put(username,points);
                if (individualStanding.containsKey(username)) {
                    individualStanding.put(username,individualStanding.get(username) + points);
                } else {
                    individualStanding.put(username,points);
                }
            }
        }
        for (Map.Entry<String, Map<String, Integer>> entry : contestUserPoints.entrySet()) {
            AtomicInteger counter = new AtomicInteger(1);
            System.out.printf("%s: %d participants\n",entry.getKey(),entry.getValue().size());
            entry.getValue().entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                    .forEach((key,value) -> {
                        System.out.printf("%s. %s <::> %d\n",counter,key,value);
                        counter.getAndIncrement();
            });
        }
        System.out.println("Individual standings:");
        AtomicInteger counter = new AtomicInteger(1);
        individualStanding.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue) -> oldValue,LinkedHashMap::new))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue) -> oldValue,LinkedHashMap::new))
                .forEach((key,value) -> {
                    System.out.printf("%s. %s -> %d\n",counter,key,value);
                    counter.getAndIncrement();
                });
    }
}
