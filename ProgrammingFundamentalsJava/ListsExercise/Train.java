package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();

        while (!command.equals("end")){

            if (command.contains("Add")){
                int wagon = Integer.parseInt(command.split(" ")[1]);
                wagons.add(wagon);
            } else {
                int wagon = Integer.parseInt(command.split(" ")[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + wagon <= maxCapacity){
                        wagons.set(i,wagon + wagons.get(i));
                        break;
                    }
                }
            }
            command = scan.nextLine();
        }
        for (int i : wagons) {
            System.out.print(i + " ");
        }
    }
}
