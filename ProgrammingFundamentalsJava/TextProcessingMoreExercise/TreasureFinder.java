package TextProcessingMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] key = Arrays.stream(scan.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        String command = scan.nextLine();

        while (!command.equals("find")) {

            StringBuilder message = new StringBuilder(command);

            for (int i = 0; i < key.length; i++) {
                int keyValue = key[i];
                for (int j = 0; j < message.length(); j += key.length) {
                    if (j + i > message.length() - 1) {
                        break;
                    }
                    message.setCharAt((j + i), (char)(message.charAt(j + i) - keyValue));
                }
            }
            int firstIndexMaterial = message.indexOf("&");
            int lastIndexMaterial = message.lastIndexOf("&");
            int firstIndexCoordinate = message.indexOf("<");
            int secondIndexCoordinate = message.indexOf(">");

            String material = message.substring(firstIndexMaterial + 1,lastIndexMaterial);
            String coordinate = message.substring(firstIndexCoordinate + 1,secondIndexCoordinate);

            System.out.printf("Found %s at %s\n",material,coordinate);

            command = scan.nextLine();
        }
    }
}
