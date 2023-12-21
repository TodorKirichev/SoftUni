package ProgrammingFundamentalsMidExamRetake_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> elements = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        int moves = 0;

        while (true){
            String input = scan.nextLine();
            if (input.equals("end")){
                break;
            }
            moves++;

            int [] index = Arrays.stream(input.split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            if (index[0] == index[1] || index[0] > elements.size() || index[1] > elements.size() || index[0] < 0 || index[1] < 0) {
                System.out.println("Invalid input! Adding additional elements to the board");
                if (elements.size() % 2 != 0){
                    elements.add(elements.size() / 2, "-" + moves + "a");
                    elements.add(elements.size() / 2 + 1, "-" + moves + "a");
                } else {
                    elements.add(elements.size() / 2, "-" + moves + "a");
                    elements.add(elements.size() / 2, "-" + moves + "a");
                }
                continue;
            } else {
                if (elements.get(index[0]).equals(elements.get(index[1]))) {
                    System.out.printf("Congrats! You have found matching elements - %s!%n",elements.get(index[0]));
                    if (index[0] > index[1]) {
                        elements.remove(index[0]);
                        elements.remove(index[1]);
                    } else {
                        elements.remove(index[1]);
                        elements.remove(index[0]);
                    }
                } else {
                    System.out.println("Try again!");
                    continue;
                }
            }
            if (elements.isEmpty()) {
                System.out.printf("You have won in %d turns!%n",moves);
                break;
            }
        }
        if (!elements.isEmpty()) {
            System.out.println("Sorry you lose :(");
            for (String e : elements) {
                System.out.print(e + " ");
            }
        }
    }
}
