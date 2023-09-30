package WhileLoopExercise;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int mistakes = Integer.parseInt(scan.nextLine());
        String taskName = scan.nextLine();
        int mark ;
        int sum = 0;
        int maxMistakes = 0;
        boolean isTrue = true;
        int tasks = 0;
        String lastTask = "";

        while (!taskName.equals("Enough")){
            lastTask=taskName;

            mark=Integer.parseInt(scan.nextLine());

            if (mark<=4){
                maxMistakes++;
                if (maxMistakes>=mistakes){
                    isTrue=false;
                    break;
                }

            }

            taskName= scan.nextLine();
            tasks++;
            sum+=mark;


        }
        if (isTrue){
            System.out.printf("Average score: %.2f%n",(double)sum/tasks);
            System.out.printf("Number of problems: %s%n",tasks);
            System.out.printf("Last problem: %s",lastTask);
        }else{
            System.out.printf("You need a break, %s poor grades.",maxMistakes);

        }
    }
}
