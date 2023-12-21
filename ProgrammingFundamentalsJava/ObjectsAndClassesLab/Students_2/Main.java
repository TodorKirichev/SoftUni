package ObjectsAndClassesLab.Students_2;

import ObjectsAndClassesLab.Students.Students_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Students_2> students = new ArrayList<>();

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

            boolean isExisting = false;
            for (Students_2 student : students) {
                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    student.setAge(age);
                    student.setHometown(hometown);
                    isExisting = true;
                    break;
                }
            }
            if (!isExisting) {
                Students_2 currentStudent = new Students_2(firstName,lastName,age,hometown);
                students.add(currentStudent);
            }
        }
        String town = scan.nextLine();
        for (
                Students_2 student : students) {
            if (student.getHometown().equals(town)) {
                System.out.printf("%s %s is %s years old%n",student.getFirstName(),student.getLastName(),student.getAge());
            }
        }
    }
}

