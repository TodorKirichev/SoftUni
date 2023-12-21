package TextProcessingLab;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] word = scan.nextLine().split(" ");

        StringBuilder result = new StringBuilder();

        for (String e : word) {
            for (int i = 0; i < e.length(); i++) {
                result.append(e);
            }
        }
        System.out.println(result);
    }
}
