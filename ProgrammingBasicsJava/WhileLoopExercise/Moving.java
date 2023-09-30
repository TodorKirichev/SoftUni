package WhileLoopExercise;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int w = Integer.parseInt(scan.nextLine());
        int l = Integer.parseInt(scan.nextLine());
        int h = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();

        int freeSpace = l*w*h;
        String command = "Done";
        int numOfBoxes = 0 ;

        while (!input.equals(command)){
            numOfBoxes = Integer.parseInt(input);
            freeSpace-=numOfBoxes;
            if (freeSpace<=0){
                break;
            }
            input= scan.nextLine();
        }
        if (freeSpace<=0){
            System.out.printf("No more free space! You need %d Cubic meters more.",Math.abs(freeSpace));
        }else{
            System.out.printf("%d Cubic meters left.",Math.abs(freeSpace));
        }
    }
}
