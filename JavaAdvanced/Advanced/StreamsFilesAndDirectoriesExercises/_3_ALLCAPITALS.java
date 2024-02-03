package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.*;

public class _3_ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));

        String line = bf.readLine();

        while (line != null) {
            pw.println(line.toUpperCase());
            line = bf.readLine();
        }
        bf.close();
        pw.close();
    }
}
