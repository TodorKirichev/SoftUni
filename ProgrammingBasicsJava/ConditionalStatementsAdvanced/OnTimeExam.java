package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class OnTimeExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hourExam = Integer.parseInt(scan.nextLine());
        int minExam = Integer.parseInt(scan.nextLine());
        int hourArrival = Integer.parseInt(scan.nextLine());
        int minArrival = Integer.parseInt(scan.nextLine());
        String timeStudent = "";
        int sumMinExam = (hourExam*60)+minExam;
        int sumMinArrival = (hourArrival*60)+minArrival;
        int diff = sumMinExam-sumMinArrival;

        if (diff >= 0 && diff <= 30) {
            timeStudent = "On time";
        } else if (diff > 30) {
            timeStudent = "Early";
        } else {
            timeStudent = "Late";
        }
        System.out.println(timeStudent);
        String befOrAft = "";
        if (diff<0){
            befOrAft="after";
        }else{
            befOrAft="before";
        }
        diff=Math.abs(diff);
        if (diff<60){
            System.out.printf("%d minutes %s the start",diff,befOrAft);
        }else{
            System.out.printf("%d:%02d hours %s the start",diff/60,diff%60,befOrAft);
        }
    }
}
