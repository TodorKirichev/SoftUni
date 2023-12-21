package ProgrammingFundamentalsMidExamRetake_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> loot = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Yohoho!")){

            String [] commandName = input.split(" ");
            String command = commandName[0];

            if (command.contains("Loot")){
                List<String> items = new ArrayList<>();
                for (int i = 1; i < commandName.length; i++) {
                    items.add(commandName[i]);
                }
                for (int i = 0; i < items.size(); i++) {
                    if (!loot.contains(items.get(i))){
                        loot.add(0,items.get(i));
                    }
                }
            } else if (command.contains("Drop")) {
                int index = Integer.parseInt(commandName[1]);
                if (index >= 0 && index < loot.size()){
                    String removed = loot.get(index);
                    loot.remove(index);
                    loot.add(removed);
                }
            } else if (command.contains("Steal")) {
                int count = Integer.parseInt(commandName[1]);
                int startCount = Math.max(0,loot.size() - count);
                List<String> stolenItems = new ArrayList<>();
                if (count > loot.size()){
                    count = loot.size();
                }
                for (int i = 0; i < count; i++) {
                    String removed = loot.get(startCount);
                    loot.remove(startCount);
                    stolenItems.add(removed);
                }
                System.out.println(String.join(", ",stolenItems));
            }
            input = scan.nextLine();
        }
        double sum = 0;
        for (int i = 0; i < loot.size(); i++) {
            String item = loot.get(i);
            sum += item.length();
        }
        if (loot.isEmpty()){
            System.out.println("Failed treasure hunt.");
        } else {
            sum /= loot.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.%n",sum);
        }
    }
}
