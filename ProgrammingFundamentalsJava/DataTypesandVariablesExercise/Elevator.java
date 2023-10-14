package DataTypesandVariablesExercise;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numPeople = Integer.parseInt(scan.nextLine());
        int elevatorCapacity = Integer.parseInt(scan.nextLine());

        int courses = numPeople/elevatorCapacity;

        if (numPeople%elevatorCapacity!=0){
            courses++;
        }
        System.out.println(courses);
    }
}
