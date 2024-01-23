package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _2_WriteToFile {
    public static void main(String[] args) throws IOException {
        String readPath = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream outputStream = new FileOutputStream(writePath);

        int currentByte = inputStream.read();

        while (currentByte >= 0) {
            char currentChar = (char) currentByte;
            if (currentChar != ',' && currentChar != '.' && currentChar != '!' && currentChar != '?') {
                outputStream.write(currentChar);
            }
            currentByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
