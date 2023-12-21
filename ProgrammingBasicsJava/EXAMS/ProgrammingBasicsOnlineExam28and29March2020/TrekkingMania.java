package ProgrammingBasicsOnlineExam28and29March2020;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numGroups = Integer.parseInt(scan.nextLine());
        int allPeoples = 0;
        int musala = 0;
        int monblan = 0;
        int kilimandjaro = 0;
        int k2 = 0;
        int evrest = 0;

        for (int i = 0; i < numGroups; i++) {
            int peoples = Integer.parseInt(scan.nextLine());
            allPeoples+=peoples;
            if (peoples<=5){
                musala+=peoples;
            }else if (peoples<=12){
                monblan+=peoples;
            }else if (peoples<=25){
                kilimandjaro+=peoples;
            }else if (peoples<=40){
                k2+=peoples;
            }else {
                evrest+=peoples;
            }
        }
        System.out.printf("%.2f%%%n",(double)musala/allPeoples*100);
        System.out.printf("%.2f%%%n",(double)monblan/allPeoples*100);
        System.out.printf("%.2f%%%n",(double)kilimandjaro/allPeoples*100);
        System.out.printf("%.2f%%%n",(double)k2/allPeoples*100);
        System.out.printf("%.2f%%%n",(double)evrest/allPeoples*100);
    }
}
