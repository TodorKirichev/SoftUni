package FINALEXAM;

import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Finish")) {
                break;
            }
            String[] commandParts = input.split(" ");
            String command = commandParts[0];
            switch (command) {
                case "Replace":
                    String currentChar = commandParts[1];
                    String newChar = commandParts[2];
                    text = text.replace(currentChar,newChar);
                    System.out.println(text);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    if (startIndex > 0 && startIndex < text.length() && endIndex > 0 && endIndex < text.length()) {
                        String substring = text.substring(startIndex,endIndex + 1);
                        text = text.replace(substring,"");
                        System.out.println(text);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
                case "Make":
                    String subCommand = commandParts[1];
                    if (subCommand.equals("Upper")) {
                        text = text.toUpperCase();
                    } else if (subCommand.equals("Lower")) {
                        text = text.toLowerCase();
                    }
                    System.out.println(text);
                    break;
                case "Check":
                    String string = commandParts[1];
                    if (text.contains(string)) {
                        System.out.printf("Message contains %s\n",string);
                    } else {
                        System.out.printf("Message doesn't contain %s\n",string);
                    }
                    break;
                case "Sum":
                    int startIdx = Integer.parseInt(commandParts[1]);
                    int endIdx = Integer.parseInt(commandParts[2]);
                    if (startIdx > 0 && startIdx < text.length() && endIdx > 0 && endIdx < text.length()) {
                        String substring = text.substring(startIdx,endIdx + 1);
                        int sum = 0;
                        for (int i = 0; i < substring.length(); i++) {
                            char ch = substring.charAt(i);
                            sum += ch;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
            }
        }
    }
}
