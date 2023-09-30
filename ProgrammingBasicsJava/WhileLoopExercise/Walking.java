package WhileLoopExercise;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int stepsForDay = 10000;
        String input = scan.nextLine();
        int steps = 0;
        String command = "Going home";
        boolean isTrue = true;

        while (!input.equals(command)){
            steps+=Integer.parseInt(input);

            if (steps>stepsForDay){
                System.out.println("Goal reached! Good job!");
                System.out.printf("%d steps over the goal!",steps-stepsForDay);
                isTrue=false;
                break;
            }
            input= scan.nextLine();
        }
        if (isTrue) {
            int stepsToHome = Integer.parseInt(scan.nextLine());
            int diffToHome = stepsForDay - (steps + stepsToHome);

            if (diffToHome <= 0) {
                System.out.println("Goal reached! Good job!");
                System.out.printf("%d steps over the goal!", Math.abs(diffToHome));
            } else {
                System.out.printf("%d more steps to reach goal.", Math.abs(diffToHome));
            }
        }
    }
}
