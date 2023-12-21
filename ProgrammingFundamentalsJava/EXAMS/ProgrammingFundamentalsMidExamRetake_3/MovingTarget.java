package ProgrammingFundamentalsMidExamRetake_3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("End")){

            String [] command = input.split(" ");
            int index = Integer.parseInt(command[1]);

            if (input.contains("Shoot")){
                int power = Integer.parseInt(command[2]);
                if (index >= 0 && index < targets.size()){
                    targets.set(index, targets.get(index) - power);
                    if (targets.get(index) <= 0){
                        targets.remove(index);
                    }
                }
            } else if (input.contains("Add")) {
                int value = Integer.parseInt(command[2]);
                if (index >= 0 && index < targets.size()){
                    targets.add(index,value);
                }else {
                    System.out.println("Invalid placement!");
                }
            } else if (input.contains("Strike")) {
                int radius = Integer.parseInt(command[2]);
                if (index - radius >= 0 && index + radius < targets.size()) {
                    for (int i = 0; i < radius * 2 + 1; i++) {
                        targets.remove((index - radius));
                    }
                } else {
                    System.out.println("Strike missed!");
                }
            }
            input = scan.nextLine();
        }
        List<String> targetsAsString = targets.stream().map(Object::toString).collect(Collectors.toList());
        System.out.println(String.join("|",targetsAsString));
    }
}
