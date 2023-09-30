package ProgrammingBasicsOnlineExam9and10March2019;

import java.util.Scanner;

public class HighJump {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int height = Integer.parseInt(scan.nextLine());
        int fail = 0;
        int jumps = 0;
        int succeededHeight = 0;
        int failedHeight = 0;

        for (int i = height-30; i <= height; i+=5) {

            int jump = Integer.parseInt(scan.nextLine());
            jumps++;

            if (jump>i){
                fail=0;
                succeededHeight=i;
                if (jump>height){
                    break;
                }
                continue;
            }
            fail++;
            if (fail>=3){
                failedHeight=i;
                break;
            }
            i=i-5;
        }
        if (succeededHeight<height) {
            System.out.printf("Tihomir failed at %dcm after %d jumps.",failedHeight,jumps);
        }else{
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.",succeededHeight,jumps);
        }
    }
}
