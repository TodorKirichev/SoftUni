package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _2_SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        String line = bf.readLine();
        int sumLine = 0;

        while (line != null) {
            for (char c : line.toCharArray()) {
                sumLine += c;
            }
            line = bf.readLine();
        }
        System.out.println(sumLine);
        bf.close();
    }
}
