package ProgrammingFundamentalsFinalExam05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Integer> cityPopulation = new LinkedHashMap<>();
        Map<String,Integer> cityGold = new LinkedHashMap<>();
        while (true) {
            String input = scan.nextLine();
            if (input.equals("Sail")) {
                break;
            }
            String[] inputData = input.split("\\|\\|");
            String city = inputData[0];
            int population = Integer.parseInt(inputData[1]);
            int gold = Integer.parseInt(inputData[2]);
            if (!cityPopulation.containsKey(city)) {
                cityPopulation.put(city,population);
                cityGold.put(city,gold);
            } else {
                cityPopulation.put(city,cityPopulation.get(city) + population);
                cityGold.put(city,cityGold.get(city) + gold);
            }
        }
        while (true) {
            String input = scan.nextLine();
            if (input.equals("End")) {
                break;
            }
            String[] inputData = input.split("=>");
            String event = inputData[0];
            String town = inputData[1];
            switch (event) {
                case "Plunder":
                    int people = Integer.parseInt(inputData[2]);
                    int goldPlunder = Integer.parseInt(inputData[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",town,goldPlunder,people);
                    cityPopulation.put(town,cityPopulation.get(town) - people);
                    cityGold.put(town,cityGold.get(town) - goldPlunder);
                    if (cityPopulation.get(town) <= 0 || cityGold.get(town) <= 0) {
                        cityPopulation.remove(town);
                        cityGold.remove(town);
                        System.out.printf("%s has been wiped off the map!\n",town);
                    }
                    break;
                case "Prosper":
                    int goldProsper = Integer.parseInt(inputData[2]);
                    if (goldProsper > 0) {
                        cityGold.put(town,cityGold.get(town) + goldProsper);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n"
                                ,goldProsper,town,cityGold.get(town));
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
        }
        if (cityPopulation.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n",cityPopulation.size());
            for (Map.Entry<String,Integer> entry : cityPopulation.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n"
                ,entry.getKey(),entry.getValue(),cityGold.get(entry.getKey()));
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
