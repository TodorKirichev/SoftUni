package ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String start = scan.nextLine();
        String end = scan.nextLine();

        int firstS = Integer.parseInt(String.valueOf(start.charAt(0)));
        int secondS = Integer.parseInt(String.valueOf(start.charAt(1)));
        int thirdS = Integer.parseInt(String.valueOf(start.charAt(2)));
        int fourthS = Integer.parseInt(String.valueOf(start.charAt(3)));

        int firstE = Integer.parseInt(String.valueOf(end.charAt(0)));
        int secondE = Integer.parseInt(String.valueOf(end.charAt(1)));
        int thirdE = Integer.parseInt(String.valueOf(end.charAt(2)));
        int fourthE = Integer.parseInt(String.valueOf(end.charAt(3)));

        for (int i = firstS; i <=firstE ; i++) {
            for (int j = secondS; j <=secondE ; j++) {
                for (int k = thirdS; k <=thirdE ; k++) {
                    for (int l = fourthS; l <=fourthE ; l++) {
                        if (i%2!=0&&j%2!=0&&k%2!=0&&l%2!=0){
                            System.out.print(String.valueOf(i)+j+k+l+" ");
                        }
                    }
                }
            }
        }
    }
}
