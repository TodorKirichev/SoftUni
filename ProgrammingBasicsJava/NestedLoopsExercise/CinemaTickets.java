package NestedLoopsExercise;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);

       String movieName = scan.nextLine();
       int studentCounter = 0;
       int standardCounter = 0;
       int kidCounter = 0;
       int sumTickets = 0;
       int allTickets = 0;
      int student = 0;
      int standard = 0;
      int kid = 0;

       while (!movieName.equals("Finish")){

           int freeSeats = Integer.parseInt(scan.nextLine());
           String ticketType = scan.nextLine();


           while (!ticketType.equals("End")){

               switch (ticketType){
                   case "student" :
                       studentCounter++;
                       break;
                   case "standard" :
                       standardCounter++;
                       break;
                   case "kid" :
                       kidCounter++;
                       break;
               }
               sumTickets=studentCounter+standardCounter+kidCounter;

               if (sumTickets>=freeSeats){

                   break;
               }



               ticketType= scan.nextLine();
           }
           System.out.printf("%s - %.2f%% full.%n",movieName,(double)sumTickets/freeSeats*100);
           allTickets+=sumTickets;
           student+=studentCounter;
           standard+=standardCounter;
           kid+=kidCounter;
           sumTickets=0;
           studentCounter = 0;
           standardCounter = 0;
           kidCounter = 0;


           movieName= scan.nextLine();
       }
        System.out.printf("Total tickets: %d%n",allTickets);
        System.out.printf("%.2f%% student tickets.%n",(double)student/allTickets*100);
        System.out.printf("%.2f%% standard tickets.%n",(double)standard/allTickets*100);
        System.out.printf("%.2f%% kids tickets.%n",(double)kid/allTickets*100);
    }
}
