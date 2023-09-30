package ForLoopMoreExercises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int period = Integer.parseInt(scan.nextLine());
        int treatedPatients = 0;
        int untreatedPatients = 0;
        int doctors = 7;
        int days = 1;

        for (int i = 1; i <= period ; i++) {
            if (days%3==0&&untreatedPatients>treatedPatients){
                doctors++;
            }
            int n = Integer.parseInt(scan.nextLine());
            if (n<doctors) {
                treatedPatients += n;
            } else {
                treatedPatients+=doctors;
            }
            if (n>doctors){
                untreatedPatients += (n-doctors);
            }
            days++;
        }
        System.out.println("Treated patients: "+treatedPatients + ".");
        System.out.println("Untreated patients: "+untreatedPatients + ".");
    }
}
