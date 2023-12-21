package ProgrammingFundamentalsFinalExamRetake03;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scan.nextLine());

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Reveal")) {
                break;
            }
            String[] commandParts = input.split(":\\|:");
            String command = commandParts[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandParts[1]);
                    message.insert(index," ");
                    break;
                case "Reverse":
                    String substringToReverse = commandParts[1];
                    if (message.toString().contains(substringToReverse)) {
                        int indexSub = message.indexOf(substringToReverse);
                        message.replace(indexSub,indexSub + substringToReverse.length(),"");
                        StringBuilder reversedSub = new StringBuilder(substringToReverse);
                        reversedSub.reverse();
                        message.append(reversedSub);
                    } else {
                        System.out.println("error");
                        continue;
                    }
                    break;
                case "ChangeAll":
                    String substringToChange = commandParts[1];
                    String replacement = commandParts[2];
                    int idx = message.indexOf(substringToChange);
                    while (idx != -1) {
                        message.replace(idx,idx + substringToChange.length(),replacement);
                        idx = message.indexOf(substringToChange);
                    }
                    break;
            }
            System.out.println(message);
        }
        System.out.printf("You have a new text message: %s\n",message);
    }
}
