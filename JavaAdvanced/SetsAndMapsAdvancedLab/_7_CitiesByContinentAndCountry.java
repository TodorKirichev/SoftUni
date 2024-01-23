package JavaAdvanced.SetsAndMapsAdvancedLab;

import java.util.*;

public class _7_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Map<String, List<String>>> continents = new LinkedHashMap<>();
        
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] inputInfo = scan.nextLine().split("\\s+");
            String continent = inputInfo[0];
            String country = inputInfo[1];
            String city = inputInfo[2];

            continents.putIfAbsent(continent,new LinkedHashMap<>());
            Map<String,List<String>> countries = continents.get(continent);
            countries.putIfAbsent(country,new ArrayList<>());
            List<String> cities = countries.get(country);
            cities.add(city);
        }
        continents.forEach((key,value) -> {
            System.out.printf("%s:\n",key);
            value.forEach((country,citiesList) -> {
                String cities = String.join(", ",citiesList);
                System.out.printf("%s -> %s\n",country,cities);
            });
        });
    }
}
