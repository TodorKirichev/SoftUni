package JavaAdvanced.StreamsFilesAndDirectoriesExercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class _8_GetFolderSize {
    public static void main(String[] args) throws IOException {
        File folder = new File("src/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources");

        File[] files = folder.listFiles();
        int size = 0;

        for (File file : files) {
            if (!file.isDirectory()) {
                size += file.length();
            }
        }
        System.out.printf("Folder size: %d\n",size);
    }
}
