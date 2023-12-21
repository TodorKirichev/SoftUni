package MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Integer> materials = new LinkedHashMap<>();
        materials.put("shards",0);
        materials.put("fragments",0);
        materials.put("motes",0);
        Map<String,Integer> junk = new LinkedHashMap<>();
        boolean isEnough = false;
        String item = "";
        while (true) {

            String[] input = scan.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < input.length; i += 2) {
                String material = input[i + 1];
                int quantity = Integer.parseInt(input[i]);
                switch (material) {
                    case "shards":
                        materials.put(material, materials.get(material) + quantity);
                        isEnough = checkIsEnough(materials,material);
                        item = "Shadowmourne";
                        break;
                    case "fragments":
                        materials.put(material, materials.get(material) + quantity);
                        isEnough = checkIsEnough(materials,material);
                        item = "Valanyr";
                        break;
                    case "motes":
                        materials.put(material, materials.get(material) + quantity);
                        isEnough = checkIsEnough(materials,material);
                        item = "Dragonwrath";
                        break;
                    default:
                        if (!junk.containsKey(material)) {
                            junk.put(material,quantity);
                        } else {
                            junk.put(material, junk.get(material) + quantity);
                        }
                        break;
                }
                if (isEnough) {
                    break;
                }
            }
            if (isEnough) {
                break;
            }
        }
        System.out.printf("%s obtained!\n",item);
        materials.forEach((key,value) -> System.out.printf("%s: %d\n",key,value));
        junk.forEach((key,value) -> System.out.printf("%s: %d\n",key,value));
    }
    private static boolean checkIsEnough(Map<String, Integer> materials, String material) {
        if (materials.get(material) >= 250) {
            materials.put(material, materials.get(material) - 250);
            return true;
        }
        return false;
    }
}
