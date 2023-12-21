package TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] path = scan.nextLine().split("\\\\");

        String file = path[path.length - 1];

        String fileName = file.split("\\.")[0];
        String fileExtension = file.split("\\.")[1];

        System.out.printf("File name: %s\n",fileName);
        System.out.printf("File extension: %s\n",fileExtension);
    }
}
