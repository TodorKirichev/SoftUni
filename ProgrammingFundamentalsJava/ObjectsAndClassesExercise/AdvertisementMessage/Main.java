package ObjectsAndClassesExercise.AdvertisementMessage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        AdvertisementMessage message = new AdvertisementMessage();

        for (int i = 0; i < n; i++) {
            message.randomMessage();
        }
    }
}
