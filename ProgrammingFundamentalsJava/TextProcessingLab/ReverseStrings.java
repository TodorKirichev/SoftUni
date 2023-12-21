package TextProcessingLab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }
            String reversed = "";

            for (int i = 0; i < input.length(); i++) {
                reversed = input.charAt(i) + reversed;
            }
            System.out.printf("%s = %s\n",input,reversed);
        }
    }
}
