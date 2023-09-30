package WhileLoopExercise;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double rest = Double.parseDouble(scan.nextLine());
        rest*=100;
        int moneyCount = 0;
        while (rest-200>=0){
            rest-=200;
            moneyCount++;
        }while (rest-100>=0){
            rest-=100;
            moneyCount++;
        }while (rest-50>=0){
            rest-=50;
            moneyCount++;
        }while (rest-20>=0){
            rest-=20;
            moneyCount++;
        }while (rest-10>=0){
            rest-=10;
            moneyCount++;
        }while (rest-5>=0){
            rest-=5;
            moneyCount++;
        }while (rest-2>=0){
            rest-=2;
            moneyCount++;
        }while (rest-1>=0){
            rest-=1;
            moneyCount++;
        }
        System.out.println(moneyCount);

    }
}
