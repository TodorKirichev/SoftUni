package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Integer> languageSubmissions = new LinkedHashMap<>();
        Map<String,Integer> usersPoints = new LinkedHashMap<>();
        List<String> usersToBan = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("exam finished")) {

            String username = input.split("-")[0];
            if (input.contains("banned")) {
                usersToBan.add(username);
            } else {
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);
                if (!usersPoints.containsKey(username)) {
                    usersPoints.put(username,points);
                } else {
                    if (points > usersPoints.get(username)) {
                        usersPoints.put(username,points);
                    }
                }

                if (!languageSubmissions.containsKey(language)) {
                    languageSubmissions.put(language,1);
                } else {
                    languageSubmissions.put(language, languageSubmissions.get(language) + 1);
                }
            }
            input = scan.nextLine();
        }
        for (String user : usersToBan) {
            usersPoints.remove(user);
        }
        System.out.println("Results:");
        usersPoints.forEach((key,value) -> {
            System.out.printf("%s | %d\n",key,value);
        });
        System.out.println("Submissions:");
        languageSubmissions.forEach((key,value) -> {
            System.out.printf("%s - %d\n",key,value);
        });
    }
}
