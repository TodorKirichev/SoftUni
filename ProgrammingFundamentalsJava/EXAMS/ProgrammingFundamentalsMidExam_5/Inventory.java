import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<String> items = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Craft!")){

            String command = input.split(" - ")[0];
            String item = input.split(" - ")[1];

            switch (command){
                case "Collect":
                    if (!items.contains(item)){
                        items.add(item);
                    }
                    break;
                case "Drop":
                    items.remove(item);
                    break;
                case "Combine Items":
                    String oldItem = item.split(":")[0];
                    String newItem = item.split(":")[1];
                    if (items.contains(oldItem)){
                        int indexOfOldItem = items.indexOf(oldItem);
                        items.add(indexOfOldItem + 1,newItem);
                    }
                    break;
                case "Renew":
                    if (items.contains(item)){
                        int index = items.indexOf(item);
                        String removed = items.get(index);
                        items.remove(item);
                        items.add(removed);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.print(String.join(", ",items));
    }
}
