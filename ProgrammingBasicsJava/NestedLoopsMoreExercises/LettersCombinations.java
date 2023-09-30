package NestedLoopsMoreExercises;

import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


//        String value = "c";
//        int charValue = value.charAt(0);
//        String next = String.valueOf((char) (charValue + 1));
//        System.out.println(next);

        String start = scan.nextLine();
        String end = scan.nextLine();
        String skip = scan.nextLine();

        int startValue = start.charAt(0);
        int endValue = end.charAt(0);
        int skipValue = skip.charAt(0);
        int counter = 0;

        for (int i = startValue; i <= endValue ; i++) {
            if (i==skipValue){
                continue;
            }
            for (int j = startValue; j <= endValue; j++) {
                if (j==skipValue){
                    continue;
                }
                for (int k = startValue; k <=endValue ; k++) {
                    if (k==skipValue){
                        continue;
                    }
                    System.out.printf("%s%s%s ",((char)i),(char)j,(char)k);
                    counter++;


                }
            }
        }
        System.out.print(counter);
    }
}
