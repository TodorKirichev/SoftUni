package JavaAdvanced.StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class _4_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String readPath = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "C:\\Users\\User\\IdeaProjects\\SoftUni\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        FileInputStream inputStream = new FileInputStream(readPath);
        FileOutputStream outputStream = new FileOutputStream(writePath);

        Scanner scan = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        String line = scan.nextLine();
        int counter = 1;

        while (scan.hasNext()) {
            if (counter % 3 == 0) {
                writer.println(line);
            }
            counter++;
            line = scan.nextLine();
        }
        scan.close();
        writer.close();
    }
}
