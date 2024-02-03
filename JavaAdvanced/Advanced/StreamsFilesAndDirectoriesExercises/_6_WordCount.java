package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _6_WordCount {
    public static void main(String[] args) throws IOException {
        Scanner scanWords = new Scanner(new FileReader("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt"));
        Scanner scanText = new Scanner(new FileReader("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/result.txt"));

        String[] words = scanWords.nextLine().split("\\s+");
        Map<String,Integer> result = new HashMap<>();

        for (String word : words) {
            result.put(word,0);
        }
        String text = scanText.next();
        while (scanText.hasNext()) {
            if (result.containsKey(text)) {
                result.put(text,result.get(text) + 1);
            }
            text = scanText.next();
        }
        result.entrySet().stream().sorted((f,s) -> s.getValue() - f.getValue()).forEach(entry -> pw.printf("%s - %d\n",entry.getKey(),entry.getValue()));
        pw.close();
    }
}
