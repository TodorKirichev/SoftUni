package ProgrammingFundamentalsMidExam_4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scan.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scan.nextLine();

        while (!command.equals("Go Shopping!")){

            modify(shoppingList,command);

            command = scan.nextLine();
        }
        System.out.println(String.join(", ",shoppingList));
    }
    public static void modify(List<String> shoppingList,String command){
        String [] input = command.split(" ");

        if (command.contains("Urgent")){
            String item = input[1];
            if (!shoppingList.contains(item)){
                shoppingList.add(0,item);
            }
        } else if (command.contains("Unnecessary")) {
            String item = input[1];
            shoppingList.remove(item);
        } else if (command.contains("Correct")) {
            String oldItem = input[1];
            String newItem = input[2];
            if (shoppingList.contains(oldItem)){
               int indexOldItem = shoppingList.indexOf(oldItem);
               shoppingList.set(indexOldItem,newItem);
            }
        } else if (command.contains("Rearrange")) {
            String item = input[1];
            if (shoppingList.contains(item)){
                shoppingList.add(item);
                shoppingList.remove(item);
            }
        }
    }
}
