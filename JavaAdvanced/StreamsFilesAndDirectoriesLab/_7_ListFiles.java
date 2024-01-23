package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.IOException;

public class _7_ListFiles {
    public static void main(String[] args) throws IOException {

        File folder = new File("C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (folder.exists()) {
            if (folder.isDirectory()) {
                File[] files = folder.listFiles();
                for (File file : files) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%d]\n",file.getName(),file.length());
                    }
                }
            }
        }
    }
}

