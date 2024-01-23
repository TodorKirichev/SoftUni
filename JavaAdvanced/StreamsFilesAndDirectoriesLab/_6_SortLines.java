package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class _6_SortLines {
    public static void main(String[] args) throws IOException {
        Path readPath = Paths.get("C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path writePath = Paths.get("C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");

        List<String> lines = Files.readAllLines(readPath);
        Collections.sort(lines);

        Files.write(writePath,lines);
    }
}
