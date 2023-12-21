package TextProcessingLab;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String first = scan.nextLine();
        String second = scan.nextLine();

//        while (second.contains(first)) {
//            second = second.replace(first,"");
//        }

        while (second.contains(first)) {
            int index = second.indexOf(first);

            String leftSub = second.substring(0,index);
            String rightSub = second.substring(index + first.length());
            second = leftSub + rightSub;
        }
        System.out.println(second);
    }
}
