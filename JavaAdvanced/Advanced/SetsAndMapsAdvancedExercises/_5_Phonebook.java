package JavaAdvanced.SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _5_Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,String> phonebook = new HashMap<>();

        fillPhonebook(scan, phonebook);
        printPhonebook(scan, phonebook);
    }

    private static void printPhonebook(Scanner scan, Map<String, String> phonebook) {
        while (true) {
            String input = scan.nextLine();
            if (input.equals("stop")) {
                break;
            }
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s\n",input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.\n",input);
            }
        }
    }

    private static void fillPhonebook(Scanner scan, Map<String, String> phonebook) {
        while (true) {
            String input = scan.nextLine();
            if (input.equals("search")) {
                break;
            }
            String[] inputData = input.split("-");
            String name = inputData[0];
            String number = inputData[1];

            phonebook.put(name,number);
        }
    }
}
