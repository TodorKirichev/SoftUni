package ProgrammingBasicsOnlineExam6and7July2019;

import java.util.Scanner;

public class Renovation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int h = Integer.parseInt(scan.nextLine());
        int w = Integer.parseInt(scan.nextLine());
        int percent = Integer.parseInt(scan.nextLine());
        int sqm = 4*h*w;
        int finalSqm = (int) Math.ceil(sqm-(sqm*percent/100.0));

        String input = scan.nextLine();

        while (!input.equals("Tired!")){
            int paint = Integer.parseInt(input);
            finalSqm-=paint;
            if (finalSqm<0){
                System.out.printf("All walls are painted and you have %d l paint left!",Math.abs(finalSqm));
                break;
            }else if (finalSqm==0){
                System.out.printf("All walls are painted! Great job, Pesho!");
                break;
            }

            input= scan.nextLine();
        }
        if (finalSqm>0) {
            System.out.printf("%d quadratic m left.", finalSqm);
        }
    }
}
