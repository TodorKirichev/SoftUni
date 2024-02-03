package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _3_CopyBytes {
    public static void main(String[] args) throws IOException {
        String readPath = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream outputStream = new FileOutputStream(writePath);

        int currentByte = inputStream.read();

        while (currentByte >= 0) {
            String string = String.valueOf(currentByte);
            if (currentByte == 32 || currentByte == 10) {
                outputStream.write(currentByte);
            } else {
                for (int i = 0; i < string.length(); i++) {
                    outputStream.write(string.charAt(i));
                }
            }
            currentByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
