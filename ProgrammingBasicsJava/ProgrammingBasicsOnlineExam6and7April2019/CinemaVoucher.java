package ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;

public class CinemaVoucher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double vaucher = Double.parseDouble(scan.nextLine());
        String purchase = scan.nextLine();
        int ticket = 0;
        int ticketCounter = 0;
        int other = 0;
        int othercounter = 0;


        while (!purchase.equals("End")&&vaucher>=0){

            if (purchase.length()>8){
                ticket=purchase.charAt(0)+purchase.charAt(1);
                vaucher-=ticket;
                if (vaucher<0){
                    break;
                }
                ticketCounter++;
            }else {
                other=purchase.charAt(0);
                vaucher-=other;
                if (vaucher<0){
                    break;
                }
                othercounter++;
            }
            purchase= scan.nextLine();
        }
        System.out.println(ticketCounter);
        System.out.println(othercounter);
    }
}
