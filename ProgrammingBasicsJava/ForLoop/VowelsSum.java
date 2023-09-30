package ForLoop;

import java.util.Scanner;

public class VowelsSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        int value =0;

        for (int i =0;i<text.length();i++){
            char letter =text.charAt(i);
            if (letter=='a'){
                value+=1;
            }else if (letter=='e'){
                value+=2;
            }else if (letter=='i'){
                value+=3;
            }else if (letter=='o'){
                value+=4;
            }else if (letter=='u'){
                value+=5;
            }


        }
        System.out.println(value);
    }


}
