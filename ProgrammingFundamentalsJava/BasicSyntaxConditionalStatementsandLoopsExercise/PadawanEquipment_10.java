package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class PadawanEquipment_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double lightSaberPrice = Double.parseDouble(scan.nextLine());
        double robePrice = Double.parseDouble(scan.nextLine());
        double beltPrice = Double.parseDouble(scan.nextLine());

        double total = ((Math.ceil(students*1.1))*lightSaberPrice)+(students*robePrice)+((students - students /6)*beltPrice);

        if (budget>=total){
            System.out.printf("The money is enough - it would cost %.2flv.",total);
        }else{
            System.out.printf("George Lucas will need %.2flv more.",total-budget);
        }
    }
}
