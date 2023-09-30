package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double capacity = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine();
        int counter = 0;

        while (!"End".equals(input)){

            double volume = Double.parseDouble(input);
            counter++;
            if (counter%3==0){
                volume*=1.1;
            }
            if (capacity<volume){
                System.out.println("No more space!");
                System.out.printf("Statistic: %d suitcases loaded.",counter-1);
                return;
            }else{
                capacity-=volume;
            }


            input= scan.nextLine();
        }
        System.out.println("Congratulations! All suitcases are loaded!");
        System.out.printf("Statistic: %d suitcases loaded.",counter);
    }
}
