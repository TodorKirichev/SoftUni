package ProgrammingBasicsOnlineExam15and16June2019;

import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String serialName = scan.nextLine();
        int seasons = Integer.parseInt(scan.nextLine());
        int episodes = Integer.parseInt(scan.nextLine());
        double duration = Double.parseDouble(scan.nextLine());

        double minutes = ((duration*1.2)*episodes*seasons)+seasons*10;

        System.out.printf("Total time needed to watch the %s series is %d minutes.",serialName,(int)Math.floor(minutes));
    }
}
