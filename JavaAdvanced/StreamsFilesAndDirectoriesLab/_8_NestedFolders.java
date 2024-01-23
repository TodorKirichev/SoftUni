package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class _8_NestedFolders {
    public static void main(String[] args) {

        File folder = new File("C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Deque<File> queue = new ArrayDeque<>();
        queue.offer(folder);
        int counter = 0;

        while (!queue.isEmpty()) {
            File file = queue.poll();
            File[] files = file.listFiles();
            System.out.println(file.getName());
            counter++;
            if (files != null) {
                for (File file1 : files) {
                    if (file1.isDirectory()) {
                        queue.offer(file1);
                    }
                }
            }
        }
        System.out.printf("%d folders\n",counter);
    }
}
