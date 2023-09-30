package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int degree = Integer.parseInt(scan.nextLine());
        String partOfDay = scan.nextLine();
        String Outfit = "" ;
        String Shoes = "" ;

        switch (partOfDay) {
            case "Morning":
                if (degree>=10 && degree<=18){
                            Outfit="Sweatshirt";
                            Shoes="Sneakers";

                }else if (degree>18 && degree<=24) {
                    Outfit="Shirt";
                            Shoes="Moccasins";

                }else if (degree>=25) {
                    Outfit="T-Shirt";
                            Shoes="Sandals";

                }
                break;
            case "Afternoon":
                if (degree>=10 && degree<=18){
                    Outfit="Shirt";
                            Shoes="Moccasins";

                }else if (degree>18 && degree<=24) {
                    Outfit="T-Shirt";
                            Shoes="Sandals";

                }else if (degree>=25) {
                    Outfit="Swim Suit";
                            Shoes="Barefoot";

                }
                break;
            case "Evening":
                if (degree>=10 && degree<=18){
                    Outfit="Shirt";
                            Shoes="Moccasins";

                }else if (degree>18 && degree<=24) {
                    Outfit="Shirt";
                            Shoes="Moccasins";

                }else if (degree>=25) {
                    Outfit="Shirt";
                            Shoes="Moccasins";

                }
                break;
        }
        System.out.printf("It's %d degrees, get your %s and %s.",degree,Outfit,Shoes);
    }
}
