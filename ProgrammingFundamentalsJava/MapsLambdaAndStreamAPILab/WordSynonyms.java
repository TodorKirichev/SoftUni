package MapsLambdaAndStreamAPILab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, List<String>> words = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();
            if (!words.containsKey(word)) {
                words.put(word,new ArrayList<>());
                words.get(word).add(synonym);
            } else {
                words.get(word).add(synonym);
            }
        }
        for (Map.Entry<String,List<String>> entry : words.entrySet()) {
            System.out.printf("%s - %s\n",entry.getKey(),String.join(", ", entry.getValue()));
        }
    }
}
