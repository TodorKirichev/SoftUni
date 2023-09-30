package ProgrammingBasicsOnlineExam6and7July2019;

import java.util.Scanner;

public class TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int sum = 0;
        int power = 0;
        String word = "";

        while (!input.equals("End of words")){
            String firstLetter = String.valueOf(input.charAt(0));

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i);

                sum+=digit;
            }
            switch (firstLetter.toLowerCase()){
                case "a":
                case "e":
                case "o":
                case "i":
                case "y":
                case "u":
                    sum*=input.length();
                    break;
                default:
                    sum/=input.length();
                    Math.floor(sum);
            }
            if (sum>power){
                power=sum;
                word=input;
            }
            sum = 0;
            input= scan.nextLine();
        }
        System.out.printf("The most powerful word is %s - %d",word,power);
    }
}
