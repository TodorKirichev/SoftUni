package ProgrammingFundamentalsFinalExamRetake01;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scan.nextLine());

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Decode")) {
                break;
            }
            String command = input.split("\\|")[0];
            switch (command) {
                case "Move":
                    int numOfLetters = Integer.parseInt(input.split("\\|")[1]);
                    String lettersToAdd = message.substring(0,numOfLetters);
                    message.replace(0,numOfLetters,"");
                    message.append(lettersToAdd);
                    break;
                case "Insert":
                    int index = Integer.parseInt(input.split("\\|")[1]);
                    String value = input.split("\\|")[2];
                    message.insert(index,value);
                    break;
                case "ChangeAll":
                    String substring = input.split("\\|")[1];
                    String replacement = input.split("\\|")[2];
                    int indexOf = message.indexOf(substring);
                    while (indexOf != -1) {
                        message.replace(indexOf,indexOf + substring.length(),replacement);
                        indexOf = message.indexOf(substring);
                    }
                    break;
            }
        }
        System.out.printf("The decrypted message is: %s\n",message);
    }
}
