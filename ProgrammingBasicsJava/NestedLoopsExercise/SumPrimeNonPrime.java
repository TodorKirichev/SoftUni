package NestedLoopsExercise;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int sumPrime = 0;
        int sumNonPrime = 0;

        while (!input.equals("stop")){

            int num = Integer.parseInt(input);
            if (num<0){
                System.out.println("Number is negative.");
                input= scan.nextLine();
                continue;
            }
            int counter = 0;
            for (int i = 1; i <=num ; i++) {
                if (num%i==0){
                    counter++;

                }
            }
            if (counter>2){
                sumNonPrime+=num;
            }else{
                sumPrime+=num;
            }

            input=scan.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n",sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d%n",sumNonPrime);
    }
}
