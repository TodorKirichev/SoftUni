package Exams.GenericsExercises.Threeuple;


import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] line1 = scan.nextLine().split("\\s+");
        String nameAndFamily = line1[0] + " " + line1[1];
        String address = line1[2];
        String town = line1[3];
        Threeuple<String,String,String> threeuple1 = new Threeuple<>(nameAndFamily,address,town);

        String[] line2 = scan.nextLine().split("\\s+");
        String name = line2[0];
        Integer litersOfBeer = Integer.parseInt(line2[1]);
        boolean drunkOrNot = line2[2].equals("drunk");
        Threeuple<String,Integer,Boolean> threeuple2 = new Threeuple<>(name,litersOfBeer,drunkOrNot);

        String[] line3 = scan.nextLine().split("\\s+");
        String name1 = line3[0];
        Double accBalance = Double.parseDouble(line3[1]);
        String bankName = line3[2];

        Threeuple<String,Double,String> threeuple3 = new Threeuple<>(name1,accBalance,bankName);


        System.out.println(threeuple1);
        System.out.println(threeuple2);
        System.out.println(threeuple3);

    }
}
