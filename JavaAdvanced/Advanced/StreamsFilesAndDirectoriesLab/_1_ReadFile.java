package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class _1_ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int currentByte = inputStream.read();

        while (currentByte >= 0) {
            System.out.print(Integer.toBinaryString(currentByte) + " ");
            currentByte = inputStream.read();
        }
    }
}
