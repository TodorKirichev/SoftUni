package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scan.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        while (firstPlayer.size() > 0 && secondPlayer.size() > 0){

                int firstPlayerCard = firstPlayer.get(0);
                int indexOfFirstCard = firstPlayer.indexOf(firstPlayerCard);
                int secondPlayerCard = secondPlayer.get(0);
                int indexOfSecondCard = secondPlayer.indexOf(secondPlayerCard);
                if (firstPlayerCard > secondPlayerCard){
                    firstPlayer.remove(indexOfFirstCard);
                    firstPlayer.add(firstPlayerCard);
                    firstPlayer.add(secondPlayerCard);
                    secondPlayer.remove(indexOfSecondCard);
                } else if (secondPlayerCard > firstPlayerCard){
                    secondPlayer.remove(indexOfSecondCard);
                    secondPlayer.add(secondPlayerCard);
                    secondPlayer.add(firstPlayerCard);
                    firstPlayer.remove(indexOfFirstCard);
                } else {
                    firstPlayer.remove(indexOfFirstCard);
                    secondPlayer.remove(indexOfSecondCard);
                }
        }
        if (firstPlayer.size() > secondPlayer.size()){
            System.out.printf("First player wins! Sum: %d",firstPlayer.stream().mapToInt(Integer::intValue).sum());
        } else {
            System.out.printf("Second player wins! Sum: %d",secondPlayer.stream().mapToInt(Integer::intValue).sum());
        }
    }
}
