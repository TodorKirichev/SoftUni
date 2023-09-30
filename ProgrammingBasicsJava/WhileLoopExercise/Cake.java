package WhileLoopExercise;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int sqmCake = width*length;

        String input = scan.nextLine();
        String command = "STOP";
        boolean isTrue=true;

        while (!input.equals(command)){
            int numPieces = Integer.parseInt(input);
            sqmCake-=numPieces;
            if (sqmCake<0){
                System.out.printf("No more cake left! You need %d pieces more.",Math.abs(sqmCake));
                isTrue=false;
                break;
            }


            input= scan.nextLine();
        }if (isTrue) {
            System.out.printf("%d pieces are left.", sqmCake);
        }

    }
}
