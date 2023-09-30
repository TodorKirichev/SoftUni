package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class FilmPremiere {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String movieName = scan.nextLine();
        String pack = scan.nextLine();
        int numTickets = Integer.parseInt(scan.nextLine());
        double price = 0;

        switch (movieName){
            case "John Wick":
                switch (pack){
                    case "Drink":
                        price=12*numTickets;
                        break;
                    case "Popcorn":
                        price=15*numTickets;
                        break;
                    case "Menu":
                        price=19*numTickets;
                        break;
                }
                break;
            case "Star Wars":
                switch (pack){
                    case "Drink":
                        price=18*numTickets;
                        break;
                    case "Popcorn":
                        price=25*numTickets;
                        break;
                    case "Menu":
                        price=30*numTickets;
                        break;
                }
                break;
            case "Jumanji":
                switch (pack){
                    case "Drink":
                        price=9*numTickets;
                        break;
                    case "Popcorn":
                        price=11*numTickets;
                        break;
                    case "Menu":
                        price=14*numTickets;
                        break;
                }
                break;
        }
        if (movieName.equals("Star Wars")&&numTickets>=4){
            price=price*0.7;
        }
        if (movieName.equals("Jumanji")&&numTickets==2){
            price=price*0.85;
        }
        System.out.printf("Your bill is %.2f leva.",price);
    }
}
