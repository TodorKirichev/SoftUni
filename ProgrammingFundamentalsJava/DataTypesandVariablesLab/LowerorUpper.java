package DataTypesandVariablesLab;

import java.util.Scanner;

public class LowerorUpper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char ch = scan.next().charAt(0);

        if (ch >= 'a' && ch <= 'z'){
            System.out.println("lower-case");
        }else {
            System.out.println("upper-case");
        }
    }
}
