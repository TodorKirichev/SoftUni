package ProgrammingBasicsOnlineExam20and21April2019;

import java.util.Scanner;

public class EasterBake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int breads = Integer.parseInt(scan.nextLine());
        int sugar = 0;
        int flour = 0;
        int sugarUsed = 0;
        int flourUsed = 0;
        int maxSugar = 0;
        int maxFlour = 0;

        for (int i = 0; i < breads; i++) {

             sugar = Integer.parseInt(scan.nextLine());
             flour = Integer.parseInt(scan.nextLine());
             sugarUsed+=sugar;
             flourUsed+=flour;

             if (sugar>maxSugar){
                 maxSugar=sugar;
             }
             if (flour>maxFlour){
                 maxFlour=flour;
             }


        }
        int numSugar = (int) Math.ceil(sugarUsed/950.0);
        int numFlour = (int) Math.ceil(flourUsed/750.0);
        System.out.printf("Sugar: %d%n",numSugar);
        System.out.printf("Flour: %d%n",numFlour);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.%n",maxFlour,maxSugar);
    }
}
