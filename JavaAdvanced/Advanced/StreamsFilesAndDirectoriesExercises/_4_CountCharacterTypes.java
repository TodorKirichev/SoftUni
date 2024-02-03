package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _4_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        int vowels = 0;
        int otherSymbols = 0;
        int punctuation = 0;

        String line =  bf.readLine();
        while (line != null) {

            String[] words = line.split("\\s+");
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    if (isVowel(c)) {
                        vowels++;
                    } else if (isPunctuation(c)) {
                        punctuation++;
                    } else if (!Character.isWhitespace(c)) {
                        otherSymbols++;
                    }
                }
            }
            line = bf.readLine();
        }
        pw.printf("Vowels: %d\n",vowels);
        pw.printf("Other symbols: %d\n",otherSymbols);
        pw.printf("Punctuation: %d\n",punctuation);
        bf.close();
        pw.close();
    }

    private static boolean isPunctuation(char c) {
        return c == '.' || c == '?' || c == '!' || c == ',';
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u';
    }
}
