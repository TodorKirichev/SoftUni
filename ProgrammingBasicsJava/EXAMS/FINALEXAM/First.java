package EXAM;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double processorPrice = Double.parseDouble(scan.nextLine());
        double videoCardPrice = Double.parseDouble(scan.nextLine());
        double ramPrice = Double.parseDouble(scan.nextLine());
        int numRams = Integer.parseInt(scan.nextLine());
        double percentDiscount = Double.parseDouble(scan.nextLine());

        processorPrice*=1.57;
        double processorAfterDiscount = processorPrice-(processorPrice*percentDiscount);
        videoCardPrice*=1.57;
        double videoCardAfterDiscount = videoCardPrice-(videoCardPrice*percentDiscount);
        ramPrice*=numRams*1.57;

        double sum = processorAfterDiscount+videoCardAfterDiscount+ramPrice;

        System.out.printf("Money needed - %.2f leva.",sum);
    }
}
