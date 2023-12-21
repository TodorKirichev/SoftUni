package ProgrammingFundamentalsFinalExam02;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String,Integer> plantsRarity = new LinkedHashMap<>();
        Map<String,List<Double>> plantsRating = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
            plantsRarity.put(plant,rarity);
            plantsRating.put(plant,new ArrayList<>());

        }
        String input = scan.nextLine();
        while (!input.equals("Exhibition")) {
            String command = input.split(": ")[0];
            String inputData = input.split(": ")[1];
            String plant = inputData.split(" - ")[0];
            if (plantsRarity.containsKey(plant)) {
                switch (command) {
                    case "Rate":
                        double rating = Double.parseDouble(inputData.split(" - ")[1]);

                            plantsRating.get(plant).add(rating);

                        break;
                    case "Update":
                        int newRarity = Integer.parseInt(inputData.split(" - ")[1]);
                        plantsRarity.put(plant,newRarity);
                        break;
                    case "Reset":
                        plantsRating.get(plant).clear();
                        break;
                }
            } else {
                System.out.println("error");
            }
            input = scan.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : plantsRarity.entrySet()) {
            String plant = entry.getKey();
            int rarity = entry.getValue();
            double averageRating = 0;

            if (plantsRating.containsKey(plant) && !plantsRating.get(plant).isEmpty()) {
                List<Double> plantRatings = plantsRating.get(plant);
                double sum = 0;
                for (double rate : plantRatings) {
                    sum += rate;
                }
                averageRating = sum / plantRatings.size();
            }
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plant, rarity, averageRating);
        }
    }
}
