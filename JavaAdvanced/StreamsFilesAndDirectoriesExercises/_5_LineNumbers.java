package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.Scanner;

public class _5_LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));

        int counter = 0;
        String line = br.readLine();
        while (line != null) {
            pw.printf("%d. %s\n",++counter,line);
            line = br.readLine();
        }
        br.close();
        pw.close();
    }
}
