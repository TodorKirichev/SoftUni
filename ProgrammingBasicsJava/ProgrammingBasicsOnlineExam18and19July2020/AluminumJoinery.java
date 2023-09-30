package ProgrammingBasicsOnlineExam18and19July2020;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numWindows = Integer.parseInt(scan.nextLine());
        String typeWindow = scan.nextLine();
        String delivery = scan.nextLine();
        double priceWindow = 0;

        if (numWindows<=10){
            System.out.println("Invalid order");
        }else {
            switch (typeWindow){
                case "90X130":
                    priceWindow=110*numWindows;
                    if (numWindows>=60){
                        priceWindow*=0.92;
                    }else if (numWindows>=30){
                        priceWindow*=0.95;
                    }
                    break;
                case "100X150":
                    priceWindow=140*numWindows;
                    if (numWindows>=80){
                        priceWindow*=0.9;
                    }else if (numWindows>=40){
                        priceWindow*=0.94;
                    }
                    break;
                case "130X180":
                    priceWindow=190*numWindows;
                    if (numWindows>=50){
                        priceWindow*=0.88;
                    }else if (numWindows>=20){
                        priceWindow*=0.93;
                    }
                    break;
                case "200X300":
                    priceWindow=250*numWindows;
                    if (numWindows>=50){
                        priceWindow*=0.86;
                    }else if (numWindows>=25){
                        priceWindow*=0.91;
                    }
                    break;
            }
            if (delivery.equals("With delivery")){
                priceWindow+=60;
            }
            if (numWindows>99){
                priceWindow*=0.96;
            }
                System.out.printf("%.2f BGN",priceWindow);
        }

    }
}
