package ProgrammingFundamentalsMidExam_4;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double foodInGrams = Double.parseDouble(scan.nextLine()) * 1000;
        double hay = Double.parseDouble(scan.nextLine());
        double cover = Double.parseDouble(scan.nextLine());
        double guineaWeight = Double.parseDouble(scan.nextLine());

        for (int i = 1; i <= 30; i++) {

            if (foodInGrams <= 0 || hay <= 0 || cover <= 0){
                break;
            }
            foodInGrams -= 300;
            if (i % 2 == 0){
                hay -= 0.05 * foodInGrams / 1000;
            }
            if (i % 3 == 0){
                cover -= 1.0 / 3 * guineaWeight;
            }
        }
        if (foodInGrams > 0 && hay > 0 && cover > 0){
            System.out.printf("Everything is fine! Puppy is happy!" +
                    " Food: %.2f, Hay: %.2f, Cover: %.2f.%n",foodInGrams / 1000.0,hay,cover);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
