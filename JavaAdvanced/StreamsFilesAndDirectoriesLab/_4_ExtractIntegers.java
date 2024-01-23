package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class _4_ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String readPath = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream outputStream = new FileOutputStream(writePath);

        Scanner scan = new Scanner(inputStream);
        PrintWriter printWriter = new PrintWriter(outputStream);

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                printWriter.println(scan.nextInt());
            }
            scan.next();
        }
        printWriter.close();
        inputStream.close();
        outputStream.close();
    }
}
