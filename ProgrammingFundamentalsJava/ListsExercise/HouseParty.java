package ListsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int commands = Integer.parseInt(scan.nextLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < commands; i++) {
            String input = scan.nextLine();
            String name = input.split(" ")[0];

            if (input.contains("is going")){
                if (list.contains(name)){
                    System.out.printf("%s is already in the list!%n",name);
                } else {
                    list.add(name);
                }
            } else if (input.contains("is not going")) {
                if (list.contains(name)){
                    list.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n",name);
                }
            }

        }
        for (String e : list) {
            System.out.println(e);
        }
    }
}
