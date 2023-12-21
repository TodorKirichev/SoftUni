package ProgrammingFundamentalsFinalExamRetake01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numOfPieces = Integer.parseInt(scan.nextLine());
        Map<String,String> pieceComposer = new LinkedHashMap<>();
        Map<String,String> pieceKey = new LinkedHashMap<>();

        for (int i = 0; i < numOfPieces; i++) {
            String input = scan.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];
            pieceComposer.put(piece,composer);
            pieceKey.put(piece,key);
        }
        while (true) {
            String[] commandParts = scan.nextLine().split("\\|");
            String command = commandParts[0];
            if (command.equals("Stop")) {
                break;
            }
            String piece = commandParts[1];
            switch (command) {
                case "Add":
                    String composer = commandParts[2];
                    String key = commandParts[3];
                    if (pieceComposer.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!\n",piece);
                    } else {
                        pieceComposer.put(piece,composer);
                        pieceKey.put(piece,key);
                        System.out.printf("%s by %s in %s added to the collection!\n",piece,composer,key);
                    }
                    break;
                case "Remove":
                    if (pieceComposer.containsKey(piece)) {
                        pieceComposer.remove(piece);
                        pieceKey.remove(piece);
                        System.out.printf("Successfully removed %s!\n",piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commandParts[2];
                    if (pieceKey.containsKey(piece)) {
                        pieceKey.put(piece,newKey);
                        System.out.printf("Changed the key of %s to %s!\n",piece,newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",piece);
                    }
                    break;
            }
        }
        for (Map.Entry<String,String> entry : pieceComposer.entrySet()) {
            String piece = entry.getKey();
            String composer = entry.getValue();
            String key = pieceKey.get(piece);
            System.out.printf("%s -> Composer: %s, Key: %s\n",piece,composer,key);
        }
    }
}
