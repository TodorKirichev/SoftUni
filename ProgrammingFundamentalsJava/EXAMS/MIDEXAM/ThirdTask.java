package ProgrammingFundamentalsMidExam22October2023;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> phones = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("End")){

            String [] commandName = input.split(" - ");
            String command = commandName[0];

            switch (command){
                case "Add":
                    String phoneToAdd = commandName[1];
                    if (!phones.contains(phoneToAdd)){
                        phones.add(phoneToAdd);
                    }
                    break;
                case "Remove":
                    String phoneToRemove = commandName[1];
                    phones.remove(phoneToRemove);
                    break;
                case "Bonus phone":
                    String oldPhone = commandName[1].split(":")[0];
                    String newPhone = commandName[1].split(":")[1];
                    if (phones.contains(oldPhone)){
                        int index = phones.indexOf(oldPhone);
                        phones.add(index + 1,newPhone);
                    }
                    break;
                case "Last":
                    String phoneToMove = commandName[1];
                    if (phones.contains(phoneToMove)){
                        int index = phones.indexOf(phoneToMove);
                        String removedPhone = phones.get(index);
                        phones.remove(index);
                        phones.add(removedPhone);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(", ",phones));
    }
}
