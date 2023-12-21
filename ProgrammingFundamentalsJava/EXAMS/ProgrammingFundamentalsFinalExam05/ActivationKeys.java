package ProgrammingFundamentalsFinalExam05;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String activationKey = scan.nextLine();
        while (true) {
            String input = scan.nextLine();
            if (input.equals("Generate")) {
                break;
            }
            String[] commandParts = input.split(">>>");
            String command = commandParts[0];
            switch (command) {
                case "Contains":
                    String substring = commandParts[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s\n",activationKey,substring);
                    } else {
                        System.out.printf("Substring not found!\n");
                    }
                    break;
                case "Flip":
                    String subCommand = commandParts[1];
                    int startIndex = Integer.parseInt(commandParts[2]);
                    int endIndex = Integer.parseInt(commandParts[3]);
                    String subStr = activationKey.substring(startIndex,endIndex);
                    if (subCommand.equals("Upper")) {
                        activationKey = activationKey.replace(subStr,subStr.toUpperCase());
                    } else if (subCommand.equals("Lower")) {
                        activationKey = activationKey.replace(subStr,subStr.toLowerCase());
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int start = Integer.parseInt(commandParts[1]);
                    int end = Integer.parseInt(commandParts[2]);
                    String sub = activationKey.substring(start,end);
                    activationKey = activationKey.replace(sub,"");
                    System.out.println(activationKey);
                    break;
            }
        }
        System.out.printf("Your activation key is: %s\n",activationKey);
    }
}
