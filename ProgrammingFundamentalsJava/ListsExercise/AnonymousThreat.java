package ListsExercise;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<String> list = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        String [] input = scan.nextLine().split(" ");


        while (!input[0].equals("3:1")){
            String command = input[0];

            switch (command){
                case "merge":
                    int startIndex = Integer.parseInt(input[1]);
                    int endIndex = Integer.parseInt(input[2]);
                    if (startIndex < 0){
                        startIndex = 0;
                    }
                    if (endIndex > list.size() - 1){
                        endIndex = list.size() - 1;
                    }
                    if (startIndex < list.size() && endIndex >= 0 && startIndex < endIndex){
                        for (int i = startIndex; i < endIndex; i++) {
                            String elementToMerge = list.get(startIndex + 1);
                            list.remove(startIndex + 1);
                            list.set(startIndex,list.get(startIndex) + elementToMerge);
                        }
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(input[1]);
                    int partitions = Integer.parseInt(input[2]);
                    String elementFromList = list.get(index);
                    list.remove(index);
                    List<String> element = Arrays.stream(elementFromList.split("")).collect(Collectors.toList());
                    int symbolsInParts = element.size() / partitions;
                    if (element.size() % partitions == 0){
                        for (int i = 0; i < partitions * symbolsInParts; i += symbolsInParts) {
                            String temp = "";
                            for (int j = 0; j < symbolsInParts; j++) {
                                temp = temp + element.get(j + i);
                            }
                            list.add(temp);
                        }

                    } else {
                        String lastSymbol = element.get(element.size() - 1);
                        for (int i = 0; i < (partitions - symbolsInParts) * symbolsInParts; i += symbolsInParts) {
                            String temp = "";
                            for (int j = 0; j < symbolsInParts; j++) {
                                temp = temp + element.get(j + i);
                            }
                            list.add(temp);
                        }
                        list.set(list.size() - 1,list.get(list.size() - 1) + lastSymbol);
                    }
                    break;
            }

            input = scan.nextLine().split(" ");
        }
        System.out.print(String.join(" ",list));

    }
}
