package MapsLambdaAndStreamAPILab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] words = scan.nextLine().toLowerCase().split(" ");

        LinkedHashMap<String,Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            if (!counts.containsKey(word)) {
                counts.put(word,1);
            } else {
                counts.put(word, counts.get(word) + 1);
            }
        }
        List<String> oods = new ArrayList<>();

        for (Map.Entry<String,Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oods.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ",oods));
    }
}
