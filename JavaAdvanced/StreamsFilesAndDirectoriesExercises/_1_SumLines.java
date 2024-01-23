package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _1_SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        String line = bf.readLine();
        while (line != null) {

            int sumLine = 0;
            for (char c : line.toCharArray()) {
                sumLine += c;
            }
            System.out.println(sumLine);
            line = bf.readLine();
        }
        bf.close();
    }
}
