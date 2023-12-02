package ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        while (true) {

            String input = scan.nextLine();

            if (input.equals("end")) {
                break;
            }
            String[] command = input.split(" ");

            if (command[0].equals("Contains")) {
                int n = Integer.parseInt(command[1]);
                if (numbers.contains(n)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }

            } else if (command[0].equals("Print") && command[1].equals("even")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 == 0) {
                        System.out.printf("%d ",numbers.get(i));
                    }
                }
                System.out.println();

            }else if (command[0].equals("Print") && command[1].equals("odd")) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 != 0) {
                        System.out.printf("%d ",numbers.get(i));
                    }
                }
                System.out.println();

            } else if (command[0].equals("Get") && command[1].equals("sum")) {
                int sum = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    sum += numbers.get(i);
                }
                System.out.println(sum);

            }else if (command[0].equals("Filter")) {
                int number = Integer.parseInt(command[2]);
                if (command[1].equals("<")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < number) {
                            System.out.printf("%d ",numbers.get(i));
                        }
                    }
                    System.out.println();
                } else if (command[1].equals(">")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) > number) {
                            System.out.printf("%d ",numbers.get(i));
                        }
                    }
                    System.out.println();
                } else if (command[1].equals("<=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) <= number) {
                            System.out.printf("%d ",numbers.get(i));
                        }
                    }
                    System.out.println();
                } else if (command[1].equals(">=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) >= number) {
                            System.out.printf("%d ",numbers.get(i));
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
