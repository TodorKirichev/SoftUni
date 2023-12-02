package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<String> topics = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("course start")){

            String [] commandName = input.split(":");
            String command = commandName[0];
            String lesson = commandName[1];

            switch (command){
                case "Add":
                    if (!topics.contains(lesson)){
                        topics.add(lesson);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandName[2]);
                    if (!topics.contains(lesson)){
                        topics.add(index,lesson);
                    }
                    break;
                case "Remove":
                    topics.remove(lesson);
                    break;
                case "Swap":
                    String lesson2 = commandName[2];

                    if (topics.contains(lesson) && topics.contains(lesson2)){
                        int firstIndex = topics.indexOf(lesson);
                        int secondIndex = topics.indexOf(lesson2);
                        String exFirst = lesson + "-Exercise";
                        String exSecond = lesson2 + "-Exercise";

                        topics.set(firstIndex,lesson2);
                        topics.set(secondIndex,lesson);

                        if (topics.contains(exFirst)){
                            topics.remove(exFirst);
                            topics.add(topics.indexOf(lesson) + 1,exFirst);
                        }
                        if (topics.contains(exSecond)){
                            topics.remove(exSecond);
                            topics.add(topics.indexOf(lesson2) + 1,exSecond);
                        }
                    }
                    break;
                case "Exercise":
                    if (topics.contains(lesson)){
                        if (!topics.contains(lesson + "-Exercise")){
                            int indexOfLesson = topics.indexOf(lesson);
                            topics.add(indexOfLesson + 1,lesson + "-Exercise");
                        }
                    } else {
                        topics.add(lesson);
                        topics.add(lesson + "-Exercise");
                    }
                    break;
            }

            input = scan.nextLine();
        }
        for (int i = 0; i < topics.size(); i++) {
            System.out.printf("%d.%s%n",i + 1,topics.get(i));
        }
    }
}
