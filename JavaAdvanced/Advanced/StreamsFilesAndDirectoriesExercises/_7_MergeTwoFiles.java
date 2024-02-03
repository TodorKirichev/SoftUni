package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class _7_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path readPath = Paths.get("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        List<String> firstFile = Files.readAllLines(readPath);

        Path readPath2 = Paths.get("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");
        List<String> secondFile = Files.readAllLines(readPath2);

        PrintWriter fw = new PrintWriter(new FileWriter("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/result.txt",true));

        for (String s : firstFile) {
            fw.println(s);
        }
        for (String s : secondFile) {
            fw.println(s);
        }
        fw.close();
    }
}
