package WhileLoopLab;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int max = Integer.MIN_VALUE;

        while (!input.equals("Stop")){
            if (Integer.parseInt(input)>max){
                max= Integer.parseInt(input);
            }
            input= scan.nextLine();
        }
        System.out.println(max);
    }
}
