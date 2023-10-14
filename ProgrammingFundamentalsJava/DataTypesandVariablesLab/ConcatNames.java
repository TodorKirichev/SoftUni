package DataTypesandVariablesLab;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String first = scan.nextLine();
        String second = scan.nextLine();
        String delimeter = scan.nextLine();

        System.out.printf("%s%s%s",first,delimeter,second);
    }
}
