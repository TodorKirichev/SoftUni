package Exams.GenericsExercises.Tuple;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        String[] line1 = scan.nextLine().split("\\s+");
        String nameAndFamily = line1[0] + " " + line1[1];
        String address = line1[2];
        Tuple<String,String> tuple1 = new Tuple<>(nameAndFamily,address);

        String[] line2 = scan.nextLine().split("\\s+");
        String name = line2[0];
        Integer litersOfBeer = Integer.parseInt(line2[1]);
        Tuple<String,Integer> tuple2 = new Tuple<>(name,litersOfBeer);

        String[] line3 = scan.nextLine().split("\\s+");
        Integer integer = Integer.parseInt(line3[0]);
        Double decimal = Double.parseDouble(line3[1]);
        Tuple<Integer,Double> tuple3 = new Tuple<>(integer,decimal);


        System.out.println(tuple1);
        System.out.println(tuple2);
        System.out.println(tuple3);
    }
}
