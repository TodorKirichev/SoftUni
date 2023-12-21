package ObjectsAndClassesLab.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<ObjectsAndClassesLab.Students.Students_2> students = new ArrayList<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }
            String [] studentArgs = input.split(" ");
            String firstName = studentArgs[0];
            String lastName = studentArgs[1];
            String age = studentArgs[2];
            String hometown = studentArgs[3];

            ObjectsAndClassesLab.Students.Students_2 currentStudent = new ObjectsAndClassesLab.Students.Students_2(firstName,lastName,age,hometown);
            students.add(currentStudent);
        }
        String town = scan.nextLine();
        for (ObjectsAndClassesLab.Students.Students_2 student : students) {
            if (student.getHometown().equals(town)) {
                System.out.printf("%s %s is %s years old%n",student.getFirstName(),student.getLastName(),student.getAge());
            }
        }
    }
}
