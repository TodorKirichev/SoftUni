package ConditionalStatementsAdvancedExercise;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String flower = scan.nextLine();
        int numFlower = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());

        double roses = 5;
        double dahlias = 3.80;
        double tulips = 2.80;
        double narcissus = 3;
        double gladiolus = 2.50;
        double price = 0;


        switch (flower){
            case "Roses":
                if (numFlower>80){
                    price = numFlower*roses*0.9;
                }else {
                    price = numFlower*roses;
                }
                break;
            case "Dahlias":
                if (numFlower>90){
                    price=dahlias*numFlower*0.85;
                }else {
                    price=dahlias*numFlower;
                }
                break;
            case "Tulips":
                if (numFlower>80){
                    price = tulips*numFlower*0.85;
                }else{
                    price = tulips*numFlower;
                }
                break;
            case "Narcissus":
                if (numFlower<120){
                    price=narcissus*numFlower*1.15;
                }else {
                    price=narcissus*numFlower;
                }
                break;
            case "Gladiolus":
                if (numFlower<80){
                    price=gladiolus*numFlower*1.2;
                }else {
                    price=gladiolus*numFlower;
                }
                break;
        } double left = Math.abs(budget - price);
        if (price<=budget){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",numFlower,flower,left);
        }else{
            System.out.printf("Not enough money, you need %.2f leva more.",left);
        }
    }
}
