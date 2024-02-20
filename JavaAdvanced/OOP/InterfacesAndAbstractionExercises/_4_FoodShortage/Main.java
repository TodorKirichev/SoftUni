package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._4_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = Integer.parseInt(scan.nextLine());

        List<Buyer> buyerList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);

            Buyer buyer = null;

            if (info.length == 4) {
                String id = info[2];
                String birthDate = info[3];
                buyer = new Citizen(name,age,id,birthDate);
            } else if (info.length == 3) {
                String group = info[2];
                buyer = new Rebel(name,age,group);
            }
            buyerList.add(buyer);
        }
        String command = scan.nextLine();
        while (!"End".equals(command)) {

            String name = command;
            for (Buyer buyer : buyerList) {
                if (buyer.getName().equals(name)) {
                    buyer.buyFood();
                }
            }
            command = scan.nextLine();
        }
        System.out.println(buyerList.stream().mapToInt(Buyer::getFood).sum());
    }
}
